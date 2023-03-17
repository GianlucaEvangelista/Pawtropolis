package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public class LookCommand extends Command {

    public LookCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, List<String> chosenCommand) {
        if(chosenCommand.size() != 1) {
            System.out.println(NOT_VALID_COMMAND);
            return false;
        }
        System.out.println("You are in room " + gameController.getMapController().getCurrentRoomName() + "\n" +
                gameController.getMapController().getCurrentRoomDescription());
        return true;
    }
}
