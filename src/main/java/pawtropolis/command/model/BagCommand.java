package pawtropolis.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

@Component
public class BagCommand extends Command {

    @Autowired
    private BagCommand(GameController gameController) {
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
