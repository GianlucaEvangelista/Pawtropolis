package pawtropolis.game.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import java.util.List;

@Component
public class BagCommand extends Command {

    @Autowired
    private BagCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        List<String> itemsInBag = gameController.getPlayer().getItemsFromBag();
        if(itemsInBag.isEmpty()) {
            System.out.println("Bag is empty");
        } else {
            String bagItems = String.join(", ", itemsInBag);
            System.out.println("In bag: " + bagItems);
        }
    }
}
