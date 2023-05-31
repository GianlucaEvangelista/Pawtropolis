package pawtropolis.game.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

@Component
public class ExitCommand extends Command {
    @Autowired
    private ExitCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        gameController.endGame();
        System.out.println("Goodbye " + gameController.getPlayer().getName() + "!");
    }
}
