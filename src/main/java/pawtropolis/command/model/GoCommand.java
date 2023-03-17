package pawtropolis.command.model;
import pawtropolis.game.GameController;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Room;
import java.util.List;
import java.util.Map;

public class GoCommand extends Command {

    private static final String DIRECTION_NOT_AVAILABLE = "There isn't a room in the required direction!";

    public GoCommand(GameController gameController) {
        super(gameController);
    }


    @Override
    public boolean execute(GameController gameController, List<String> chosenCommand) {
        if(chosenCommand.size() != 2) {
            return false;
        }
        Direction direction;
        try {
            direction = Direction.valueOf(chosenCommand.get(1).toUpperCase());
        } catch (IllegalArgumentException e) {
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
