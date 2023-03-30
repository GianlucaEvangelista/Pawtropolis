package pawtropolis.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

@Component
public class UnknownCommand extends Command {

    @Autowired
    private UnknownCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(String commandArgInput) {
        System.out.println(NOT_VALID_COMMAND);
        return false;
    }
}
