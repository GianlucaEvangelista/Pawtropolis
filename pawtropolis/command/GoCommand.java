package pawtropolis.command;
import pawtropolis.game.GameController;
import pawtropolis.map.Room;

public class GoCommand extends Command{
    protected GoCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    protected boolean execute(GameController gameController, String commandArgument) {
        Room[] currentAdjacentRooms = gameController.getMapController().getCurrentRoom().getAdjacentRooms();
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

    public static boolean goNorth(GameController gameController, Room[] currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms[0] != null) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms[0]);
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }

    public static boolean goEast(GameController gameController, Room[] currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms[1] != null) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms[1]);
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }

    public static boolean goSouth(GameController gameController, Room[] currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms[2] != null) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms[2]);
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }

    public static boolean goWest(GameController gameController, Room[] currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms[3] != null) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms[3]);
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }
}
