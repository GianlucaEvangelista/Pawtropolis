package pawtropolis.command;
import pawtropolis.game.GameController;
import pawtropolis.player.Item;
import java.util.List;
import java.util.stream.Collectors;

public class BagCommand extends Command {

    protected BagCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    protected boolean execute(GameController gameController, String commandArgument) {
        List<Item> bagItems = gameController.getPlayer().getBag().getItems();
        if(bagItems.isEmpty()) {
            System.out.println("Bag is empty");
        } else {
            String bagItemsNames = bagItems.stream().map(Item::getName).collect(Collectors.joining(", "));
            System.out.println("In bag: " + bagItemsNames);
        }
        return true;
    }
}