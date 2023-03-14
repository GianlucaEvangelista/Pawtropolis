package pawtropolis.command.model;
import pawtropolis.game.GameController;

public abstract class Command {

    protected final GameController gameController;

    public Command(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract boolean execute(GameController gameController, String commandArgument);
}
