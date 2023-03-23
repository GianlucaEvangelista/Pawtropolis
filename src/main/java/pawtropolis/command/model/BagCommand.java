package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public class BagCommand extends Command {

    public BagCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(String commandArgInput) {
        if(commandArgInput != null) {
            System.out.println(NOT_VALID_COMMAND);
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
