package pawtropolis.command.model;
import pawtropolis.game.GameController;

public class DropCommand extends Command {
    public DropCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, String[] chosenCommand) {
        if(chosenCommand.length <= 1) {
            return false;
        }
        if(gameController.getPlayer().itemIsInBag(chosenCommand[1])) {
            gameController.getMapController().addItemToCurrentRoom(chosenCommand[1]);
            gameController.getPlayer().removeItemFromBag(chosenCommand[1]);
            return true;
        }
        System.out.println("Required item is not in the bag!");
        return false;
    }
}
