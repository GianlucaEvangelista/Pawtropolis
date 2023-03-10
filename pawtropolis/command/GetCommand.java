package pawtropolis.command;
import pawtropolis.game.GameController;
import pawtropolis.player.Item;

import java.util.List;

public class GetCommand extends Command {
    protected GetCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    protected boolean execute(GameController gameController, String commandArgument) {
        List<Item> roomItems = gameController.getMapController().getCurrentRoom().getItems();
        for (Item item : roomItems) {
            if(item.getName().equals(commandArgument) && (gameController.getPlayer().getBag().getAvailableSlots() - item.getRequiredSlots() >= 0)) {
                gameController.getPlayer().getBag().addItem(item);
                gameController.getMapController().getCurrentRoom().removeItem(item);
                return true;
            } else if (item.getName().equals(commandArgument) && (gameController.getPlayer().getBag().getAvailableSlots() - item.getRequiredSlots() < 0)) {
                System.out.println("Not enough slots in the bag!");
                return false;
            }
        }
        System.out.println("Required item is not in the room!");
        return false;
    }
}
