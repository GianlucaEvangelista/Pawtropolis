package pawtropolis.game.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.game.model.Item;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Door;
import pawtropolis.map.model.Room;
import pawtropolis.utils.Pair;
import java.util.Map;

@Component
public class GoCommand extends Command implements CommandWithArg {

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
            System.out.println("Invalid direction!");
            return;
        }
        Map<Direction, Pair<Room, Door>> currentAdjacentRooms = gameController.getMapController().getCurrentRoomAdjacentRooms();
        if(currentAdjacentRooms.containsKey(direction)) {
            Door nextRoomDoor =  currentAdjacentRooms.get(direction).getSecond();
            if(nextRoomDoor.isLocked()) {
                tryToUnlockDoor(nextRoomDoor, direction);
            } else {
                gameController.getMapController().changeRoom(direction);
            }
            System.out.println(gameController.getMapController().getCurrentRoomDescription());
        } else {
            System.out.println("There isn't a room in the required direction!");
        }
    }

    public void tryToUnlockDoor(Door door, Direction direction) {
        System.out.println("The door is locked: would you like to use an item to unlock it? Y/N");
        String inputString = InputController.getInputString().toUpperCase();
        switch (inputString) {
            case "Y":
                System.out.println("Type the name of the item to use");
                String chosenItemName = InputController.getInputString().toLowerCase();
                if(!gameController.getPlayer().isItemInBag(chosenItemName)) {
                    System.out.println("You don't have this item in your bag!");
                } else {
                    Item chosenItem = gameController.getPlayer().getItemFromBag(chosenItemName);
                    if(door.unlockDoor(chosenItem)) {
                        gameController.getMapController().unlockDoorEntity(door);
                        gameController.getPlayer().removeItemFromBag(chosenItem);
                        gameController.getPlayerService().removeItemEntityFromBagEntity(chosenItem, gameController.getPlayer());
                        System.out.println("You unlocked the door!");
                        gameController.getMapController().changeRoom(direction);
                    } else {
                        System.out.println("This isn't the right item to unlock this door!");
                    }
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
