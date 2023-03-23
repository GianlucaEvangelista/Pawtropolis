package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public class DropCommand extends Command {
    public DropCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(String commandArgInput) {
        if(commandArgInput == null) {
            System.out.println(NOT_VALID_COMMAND);
            return false;
        }
        if(gameController.getPlayer().isItemInBag(commandArgInput)) {
            gameController.getMapController().addItemToCurrentRoom(commandArgInput);
            gameController.getPlayer().removeItemFromBag(commandArgInput);
            System.out.println("You dropped " + commandArgInput + " out of the bag");
            return true;
        }
        System.out.println("Required item is not in the bag!");
        return false;
    }
}
