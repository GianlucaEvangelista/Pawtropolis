package pawtropolis.game.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

@Component
public class GetCommand extends Command implements CommandWithArg {

    private String commandArg;

    @Autowired
    private GetCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        if(commandArg == null) {
            notValidArg();
            return;
        }
        if(gameController.getMapController().currentRoomContainsItem(commandArg)) {
            if(gameController.getPlayer().hasEnoughSpaceInBag(gameController.getMapController().getCurrentRoomItem(commandArg))) {
                gameController.getPlayer().addItemToBag(gameController.getMapController().getCurrentRoomItem(commandArg));
                gameController.getMapController().removeItemFromCurrentRoom(gameController.getMapController().getCurrentRoomItem(commandArg));
                System.out.println("You put " + commandArg + " in the bag");
                return;
            }
            System.out.println("Not enough slots in the bag!");
            return;
        }
        System.out.println("Required item is not in the room!");
    }

    @Override
    public void setCommandArg(String commandArgInput) {
        this.commandArg = commandArgInput;
    }
}
