package pawtropolis.command.model;
import pawtropolis.game.GameController;

public abstract class Command {

    protected final GameController gameController;

    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    protected static final String NOT_VALID_COMMAND = "Command isn't valid!";

    public abstract void execute(String commandArgInput);
}
