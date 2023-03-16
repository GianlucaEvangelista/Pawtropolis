package pawtropolis.command.model;
import pawtropolis.game.GameController;
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
        if(chosenCommand.size() != 2 || !(chosenCommand.get(1).equals("north") || chosenCommand.get(1).equals("south") || chosenCommand.get(1).equals("east") || chosenCommand.get(1).equals("west"))) {
            return false;
        }
        Map<String, Room> currentAdjacentRooms = gameController.getMapController().getCurrentRoomAdjacentRooms();
        if(currentAdjacentRooms.containsKey(chosenCommand.get(1))) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get(chosenCommand.get(1)));
            System.out.println("You are in room " + gameController.getMapController().getCurrentRoomName() + "\n" +
                    gameController.getMapController().getCurrentRoomDescription());
            return true;
        } else {
            System.out.println(DIRECTION_NOT_AVAILABLE);
            return false;
        }
    }

}
