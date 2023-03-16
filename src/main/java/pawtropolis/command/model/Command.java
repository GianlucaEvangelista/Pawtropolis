package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public abstract class Command {

    protected final GameController gameController;

    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract boolean execute(GameController gameController, List<String> chosenCommand);
}
