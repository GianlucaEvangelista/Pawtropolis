package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public abstract class Command {

    protected final GameController gameController;

    protected static final String NOT_VALID_COMMAND = "Command isn't valid!";

    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract boolean execute(GameController gameController, List<String> chosenCommand);
}
