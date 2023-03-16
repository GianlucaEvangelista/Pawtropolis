package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public class BagCommand extends Command {

    public BagCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, List<String> chosenCommand) {
        if(chosenCommand.size() != 1) {
            return false;
        }
        if(gameController.getPlayer().getItemsInBag().isEmpty()) {
            System.out.println("Bag is empty");
        } else {
            String bagItems = String.join(", ", gameController.getPlayer().getItemsInBag());
            System.out.println("In bag: " + bagItems);
        }
        return true;
    }
}
