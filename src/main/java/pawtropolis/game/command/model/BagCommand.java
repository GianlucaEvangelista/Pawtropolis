package pawtropolis.game.command.model;
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
    public void execute() {
        if(gameController.getPlayer().getItemsInBag().isEmpty()) {
            System.out.println("Bag is empty");
        } else {
            String bagItems = String.join(", ", gameController.getPlayer().getItemsInBag());
            System.out.println("In bag: " + bagItems);
        }
    }
}
