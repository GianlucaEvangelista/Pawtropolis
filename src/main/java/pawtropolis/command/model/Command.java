package pawtropolis.command.model;
import pawtropolis.game.GameController;

public abstract class Command {

    protected final GameController gameController;

    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract boolean execute(GameController gameController, String[] chosenCommand);
}
