package pawtropolis.command.model;
import lombok.AllArgsConstructor;
import pawtropolis.game.GameController;
import java.util.List;

@AllArgsConstructor
public abstract class Command {

    protected final GameController gameController;

    protected static final String NOT_VALID_COMMAND = "Command isn't valid!";

    public abstract boolean execute(List<String> chosenCommand);
}
