package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public class ExitCommand extends Command {
    public ExitCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, List<String> chosenCommand) {
        if(chosenCommand.size() != 1) {
            System.out.println(NOT_VALID_COMMAND);
            return false;
        }
        gameController.endGame();
        System.out.println("Goodbye " + gameController.getPlayer().getName() + "!");
        return true;
    }
}
