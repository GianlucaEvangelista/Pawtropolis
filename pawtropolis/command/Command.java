package pawtropolis.command;
import pawtropolis.game.GameController;

public abstract class Command {

    protected final GameController gameController;

    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    protected abstract boolean execute(GameController gameController, String commandArgument);
}
