package pawtropolis.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

@Component
public class LookCommand extends Command {

    @Autowired
    private LookCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(String commandArgInput) {
        if(commandArgInput != null) {
            System.out.println(NOT_VALID_COMMAND);
            return false;
        }
        System.out.println(gameController.getMapController().getCurrentRoomDescription(gameController));
        return true;
    }
}
