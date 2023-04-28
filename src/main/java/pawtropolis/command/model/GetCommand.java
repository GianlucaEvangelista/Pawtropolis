package pawtropolis.command.model;
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
    public void execute(String commandArgInput) {
        if(commandArgInput == null) {
            System.out.println(NOT_VALID_COMMAND);
            return;
        }
        if(gameController.getMapController().currentRoomContainsItem(commandArgInput)) {
            if(gameController.getPlayer().isThereEnoughSpace(gameController.getMapController().getCurrentRoomItem(commandArgInput))) {
                gameController.getPlayer().addItemToBag(gameController.getMapController().getCurrentRoomItem(commandArgInput));
                gameController.getMapController().removeItemFromCurrentRoom(gameController.getMapController().getCurrentRoomItem(commandArgInput));
                System.out.println("You put " + commandArgInput + " in the bag");
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
