package pawtropolis.command.model;
import pawtropolis.game.GameController;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Room;
import java.util.List;
import java.util.Map;

public class GoCommand extends Command {

    private static final String DIRECTION_NOT_AVAILABLE = "There isn't a room in the required direction!";
    private static final String INVALID_DIRECTION = "Invalid direction!";

    public GoCommand(GameController gameController) {
        super(gameController);
    }


    @Override
    public boolean execute(String commandArgInput) {
        if(commandArgInput == null) {
            System.out.println(NOT_VALID_COMMAND);
            return false;
        }
        Direction direction = Direction.fromString(commandArgInput);
        if(direction.equals(Direction.UNKNOWN)) {
            System.out.println(INVALID_DIRECTION);
            return false;
        }
        Map<Direction, Room> currentAdjacentRooms = gameController.getMapController().getCurrentRoomAdjacentRooms();
        if(currentAdjacentRooms.containsKey(direction)) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get(direction));
            System.out.println("You are in room " + gameController.getMapController().getCurrentRoomName() + "\n" +
                    gameController.getMapController().getCurrentRoomDescription());
            return true;
        } else {
            System.out.println(DIRECTION_NOT_AVAILABLE);
            return false;
        }
    }

}
