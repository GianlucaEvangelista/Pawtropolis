package pawtropolis.command.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;

@Component
public class GetCommand extends Command {
    @Autowired
    private GetCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(String commandArgInput) {
        if(commandArgInput == null) {
            System.out.println(NOT_VALID_COMMAND);
            return false;
        }
        if(gameController.getMapController().currentRoomContainsItem(commandArgInput)) {
            if(gameController.getPlayer().isThereEnoughSpace(gameController.getMapController().getCurrentRoomItem(commandArgInput))) {
                gameController.getPlayer().addItemToBag(gameController.getMapController().getCurrentRoomItem(commandArgInput));
                gameController.getMapController().removeItemFromCurrentRoom(gameController.getMapController().getCurrentRoomItem(commandArgInput));
                System.out.println("You put " + commandArgInput + " in the bag");
                return true;
            }
            System.out.println("Not enough slots in the bag!");
            return false;
        }
        System.out.println("Required item is not in the room!");
        return false;
    }
}
