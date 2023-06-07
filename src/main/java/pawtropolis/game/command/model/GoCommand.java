package pawtropolis.game.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Door;
import pawtropolis.map.model.Room;
import pawtropolis.utils.Pair;
import java.util.Map;

@Component
public class GoCommand extends Command implements CommandWithArg {

    private static final String DIRECTION_NOT_AVAILABLE = "There isn't a room in the required direction!";
    private static final String INVALID_DIRECTION = "Invalid direction!";

    private String commandArg;

    @Autowired
    private GoCommand(GameController gameController) {
        super(gameController);
    }


    @Override
    public void execute() {
        if(commandArg == null) {
            notValidArg();
            return;
        }
        Direction direction = Direction.fromString(commandArg);
        if(direction.equals(Direction.UNKNOWN)) {
            System.out.println(INVALID_DIRECTION);
            return;
        }
        Map<Direction, Pair<Room, Door>> currentAdjacentRooms = gameController.getMapController().getCurrentRoomAdjacentRooms();
        if(currentAdjacentRooms.containsKey(direction)) {
            Door nextRoomDoor = gameController.getMapController().getCurrentRoomAdjacentRoomDoor(direction);
            if(nextRoomDoor.isLocked()) {
                tryToUnlockDoor(nextRoomDoor, direction);
            } else {
                gameController.getMapController().changeRoom(direction);
            }
            System.out.println(gameController.getMapController().getCurrentRoomDescription());
        } else {
            System.out.println(DIRECTION_NOT_AVAILABLE);
        }
    }

    public void tryToUnlockDoor(Door door, Direction direction) {
        System.out.println("The door is locked: would you like to use an item to unlock it? Y/N");
        switch (InputController.getInputString()) {
            case "Y":
                System.out.println("Type the name of the item to use");
                String chosenItemName = InputController.getInputString();
                if(!gameController.getPlayer().isItemInBag(chosenItemName)) {
                    System.out.println("You don't have this item in your bag!");
                } else if(door.unlockDoor(gameController.getPlayer().getItemInBag(chosenItemName))) {
                    gameController.getPlayer().removeItemFromBag(gameController.getPlayer().getItemInBag(chosenItemName));
                    System.out.println("You unlocked the door!");
                    gameController.getMapController().changeRoom(direction);
                }
                break;
            case "N":
                break;
            default:
                System.out.println("Invalid choice! The door is still locked");
                break;
        }
    }

    @Override
    public void setCommandArg(String commandArgInput) {
        this.commandArg = commandArgInput;
    }
}
