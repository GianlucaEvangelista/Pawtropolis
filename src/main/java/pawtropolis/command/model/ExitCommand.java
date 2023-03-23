package pawtropolis.command.model;
import pawtropolis.game.GameController;

public class ExitCommand extends Command {
    public ExitCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(String commandArgInput) {
        if(commandArgInput != null) {
            System.out.println(NOT_VALID_COMMAND);
            return false;
        }
        gameController.endGame();
        System.out.println("Goodbye " + gameController.getPlayer().getName() + "!");
        return true;
    }
}
