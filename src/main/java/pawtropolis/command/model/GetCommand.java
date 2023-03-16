package pawtropolis.command.model;
import pawtropolis.game.GameController;
import java.util.List;

public class GetCommand extends Command {
    public GetCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, List<String> chosenCommand) {
        if(chosenCommand.size() <= 1) {
            return false;
        }
        if(gameController.getMapController().currentRoomContainsItem(chosenCommand.get(1))) {
            if(gameController.getPlayer().isThereEnoughSpace(gameController.getMapController().getCurrentRoomItem(chosenCommand.get(1)))) {
                gameController.getPlayer().addItemToBag(gameController.getMapController().getCurrentRoomItem(chosenCommand.get(1)));
                gameController.getMapController().removeItemFromCurrentRoom(gameController.getMapController().getCurrentRoomItem(chosenCommand.get(1)));
                return true;
            }
            System.out.println("Not enough slots in the bag!");
            return false;
        }
        System.out.println("Required item is not in the room!");
        return false;
    }
}
