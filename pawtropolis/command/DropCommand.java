package pawtropolis.command;
import pawtropolis.game.GameController;
import pawtropolis.player.Item;

import java.util.List;

public class DropCommand extends Command {
    protected DropCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    protected boolean execute(GameController gameController, String commandArgument) {
        List<Item> bagItems = gameController.getPlayer().getBag().getItems();
        for (Item item : bagItems) {
            if(item.getName().equals(commandArgument)) {
                gameController.getPlayer().getBag().removeItem(item);
                gameController.getMapController().getCurrentRoom().addItem(item);
                return true;
            }
        }
        System.out.println("Required item is not in the bag!");
        return false;
    }
}
