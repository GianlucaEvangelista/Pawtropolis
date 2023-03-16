package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public class DropCommand extends Command {
    public DropCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, List<String> chosenCommand) {
        if(chosenCommand.size() <= 1) {
            return false;
        }
        if(gameController.getPlayer().itemIsInBag(chosenCommand.get(1))) {
            gameController.getMapController().addItemToCurrentRoom(chosenCommand.get(1));
            gameController.getPlayer().removeItemFromBag(chosenCommand.get(1));
            return true;
        }
        System.out.println("Required item is not in the bag!");
        return false;
    }
}
