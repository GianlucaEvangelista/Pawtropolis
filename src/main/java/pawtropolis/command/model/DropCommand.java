package pawtropolis.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

@Component
public class DropCommand extends Command {
    @Autowired
    private DropCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute(String commandArgInput) {
        if(commandArgInput == null) {
            System.out.println(NOT_VALID_COMMAND);
            return;
        }
        if(gameController.getPlayer().isItemInBag(commandArgInput)) {
            gameController.getMapController().addItemToCurrentRoom(commandArgInput, gameController);
            gameController.getPlayer().removeItemFromBag(commandArgInput);
            System.out.println("You dropped " + commandArgInput + " out of the bag");
            return;
        }
        System.out.println("Required item is not in the bag!");
    }
}
