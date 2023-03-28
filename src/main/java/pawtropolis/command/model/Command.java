package pawtropolis.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

@Component
public abstract class Command {

    protected final GameController gameController;

    @Autowired
    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    protected static final String NOT_VALID_COMMAND = "Command isn't valid!";

    public abstract boolean execute(String commandArgInput);
}
