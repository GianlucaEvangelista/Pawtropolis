package pawtropolis.command;
import pawtropolis.game.GameController;
import pawtropolis.map.Room;
import java.util.Map;

public class GoCommand extends Command{
    protected GoCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    protected boolean execute(GameController gameController, String commandArgument) {
        Map<String, Room> currentAdjacentRooms = gameController.getMapController().getCurrentRoom().getAdjacentRooms();
        String directionNotAvailable = "There isn't a room in the required direction!";
        switch(commandArgument) {
            case "north":
                return goNorth(gameController, currentAdjacentRooms, directionNotAvailable);
            case "east":
                return goEast(gameController, currentAdjacentRooms, directionNotAvailable);
            case "south":
                return goSouth(gameController, currentAdjacentRooms, directionNotAvailable);
            case "west":
                return goWest(gameController, currentAdjacentRooms, directionNotAvailable);
            default:
                break;
        }
        return false;
    }

    public static boolean goNorth(GameController gameController, Map<String, Room> currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms.containsKey("north")) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get("north"));
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }

    public static boolean goEast(GameController gameController, Map<String, Room> currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms.containsKey("east")) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get("east"));
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }

    public static boolean goSouth(GameController gameController, Map<String, Room> currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms.containsKey("south")) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get("south"));
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }

    public static boolean goWest(GameController gameController, Map<String, Room> currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms.containsKey("west")) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get("west"));
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }
}
