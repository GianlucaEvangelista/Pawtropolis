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
    public void execute() {
        this.notValidCommand();
    }
}
