package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public class UnknownCommand extends Command {
    public UnknownCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(String commandArgInput) {
        System.out.println(NOT_VALID_COMMAND);
        return false;
    }
}
