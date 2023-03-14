package pawtropolis.command;
import pawtropolis.game.GameController;

public class DropCommand extends Command {
    protected DropCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    protected boolean execute(GameController gameController, String commandArgument) {
            if(gameController.getPlayer().itemIsInBag(commandArgument)) {
                gameController.getPlayer().removeItemFromBag(commandArgument);
                gameController.getMapController().addItemToCurrentRoom(commandArgument);
                return true;
            }
        System.out.println("Required item is not in the bag!");
        return false;
    }
}
