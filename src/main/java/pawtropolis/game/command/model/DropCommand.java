package pawtropolis.game.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.model.Item;

@Component
public class DropCommand extends Command implements CommandWithArg {

    private String commandArg;

    @Autowired
    private DropCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        if(commandArg == null) {
            notValidArg();
            return;
        }
        if(gameController.getPlayer().isItemInBag(commandArg)) {
            Item chosenItem = gameController.getPlayer().getItemFromBag(commandArg);
            gameController.getMapController().addItemToCurrentRoom(chosenItem);
            gameController.getPlayer().removeItemFromBag(chosenItem);
            System.out.println("You dropped " + commandArg + " out of the bag");
            return;
        }
        System.out.println("Required item is not in the bag!");
    }

    @Override
    public void setCommandArg(String commandArgInput) {
        this.commandArg = commandArgInput;
    }
}
