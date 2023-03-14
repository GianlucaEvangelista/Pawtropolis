package pawtropolis.command.model;
import pawtropolis.command.model.Command;
import pawtropolis.game.GameController;

public class LookCommand extends Command {

    public LookCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, String commandArgument) {
        System.out.println("You are in room " + gameController.getMapController().getCurrentRoomName() + "\n" +
                gameController.getMapController().getCurrentRoomDescription());
        return true;
    }
}
