package pawtropolis.command.model;
import pawtropolis.command.model.Command;
import pawtropolis.game.GameController;

public class GetCommand extends Command {
    public GetCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, String commandArgument) {
        if(gameController.getMapController().currentRoomContainsItem(commandArgument)) {
            if(gameController.getPlayer().isThereEnoughSpace(gameController.getMapController().getCurrentRoomItem(commandArgument))) {
                gameController.getPlayer().addItemToBag(gameController.getMapController().getCurrentRoomItem(commandArgument));
                gameController.getMapController().removeItemFromCurrentRoom(gameController.getMapController().getCurrentRoomItem(commandArgument));
                return true;
            }
            System.out.println("Not enough slots in the bag!");
            return false;
        }
        System.out.println("Required item is not in the room!");
        return false;
    }
}
