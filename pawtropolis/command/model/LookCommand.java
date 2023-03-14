package pawtropolis.command.model;
import pawtropolis.game.GameController;

public class LookCommand extends Command {

    public LookCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, String[] chosenCommand) {
        if(chosenCommand.length != 1) {
            return false;
        }
        System.out.println("You are in room " + gameController.getMapController().getCurrentRoomName() + "\n" +
                gameController.getMapController().getCurrentRoomDescription());
        return true;
    }
}
