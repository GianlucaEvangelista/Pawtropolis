package pawtropolis.command.model;
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
    public boolean execute(String commandArgInput) {
        if(commandArgInput != null) {
            System.out.println(NOT_VALID_COMMAND);
            return false;
        }
        gameController.endGame();
        System.out.println("Goodbye " + gameController.getPlayer().getName() + "!");
        return true;
    }
}
