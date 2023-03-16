package pawtropolis.command.model;
import pawtropolis.game.GameController;

public class ExitCommand extends Command {
    public ExitCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, String[] chosenCommand) {
        if(chosenCommand.length != 1) {
            return false;
        }
        gameController.endGame();
        System.out.println("Goodbye " + gameController.getPlayer().getName() + "!");
        return true;
    }
}
