package pawtropolis.command.model;
import pawtropolis.game.GameController;

public class GetCommand extends Command {
    public GetCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, String[] chosenCommand) {
        if(chosenCommand.length <= 1) {
            return false;
        }
        if(gameController.getMapController().currentRoomContainsItem(chosenCommand[1])) {
            if(gameController.getPlayer().isThereEnoughSpace(gameController.getMapController().getCurrentRoomItem(chosenCommand[1]))) {
                gameController.getPlayer().addItemToBag(gameController.getMapController().getCurrentRoomItem(chosenCommand[1]));
                gameController.getMapController().removeItemFromCurrentRoom(gameController.getMapController().getCurrentRoomItem(chosenCommand[1]));
                return true;
            }
            System.out.println("Not enough slots in the bag!");
            return false;
        }
        System.out.println("Required item is not in the room!");
        return false;
    }
}
