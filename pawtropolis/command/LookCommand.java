package pawtropolis.command;
import pawtropolis.game.GameController;

public class LookCommand extends Command{

    protected LookCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    protected boolean execute(GameController gameController, String commandArgument) {
        System.out.println("You are in room " + gameController.getMapController().getCurrentRoomName() + "\n" +
                gameController.getMapController().getCurrentRoomDescription());
        return true;
    }
}
