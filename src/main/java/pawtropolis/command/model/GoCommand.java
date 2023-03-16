package pawtropolis.command.model;
import pawtropolis.game.GameController;
import pawtropolis.map.model.Room;
import java.util.Map;

public class GoCommand extends Command {

    private final String direction;

    private static final String DIRECTION_NOT_AVAILABLE = "There isn't a room in the required direction!";

    public GoCommand(GameController gameController, String direction) {
        super(gameController);
        this.direction = direction;
    }

    @Override
    public boolean execute(GameController gameController, String[] chosenCommand) {
        Map<String, Room> currentAdjacentRooms = gameController.getMapController().getCurrentRoomAdjacentRooms();
        if(currentAdjacentRooms.containsKey(getDirection())) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get(getDirection()));
            System.out.println("You are in room " + gameController.getMapController().getCurrentRoomName() + "\n" +
                    gameController.getMapController().getCurrentRoomDescription());
            return true;
        } else {
            System.out.println(DIRECTION_NOT_AVAILABLE);
            return false;
        }
    }

    public String getDirection() {
        return direction;
    }

}
