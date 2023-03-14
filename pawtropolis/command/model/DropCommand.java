package pawtropolis.command.model;
import pawtropolis.command.model.Command;
import pawtropolis.game.GameController;

public class DropCommand extends Command {
    public DropCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, String commandArgument) {
            if(gameController.getPlayer().itemIsInBag(commandArgument)) {
                gameController.getPlayer().removeItemFromBag(commandArgument);
                gameController.getMapController().addItemToCurrentRoom(commandArgument);
                return true;
            }
        System.out.println("Required item is not in the bag!");
        return false;
    }
}
