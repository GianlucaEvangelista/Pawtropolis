package pawtropolis.command;
import pawtropolis.game.GameController;
import pawtropolis.player.Item;
import java.util.List;
import java.util.stream.Collectors;

public class LookCommand extends Command{

    protected LookCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    protected boolean execute(GameController gameController, String commandArgument) {
        String roomItems = "";
        String roomNPCs = "";
        if(!gameController.getMapController().getCurrentRoom().getItems().isEmpty()) {
            List<String> roomItemsNames = gameController.getMapController().getCurrentRoom().getItems().stream().map(Item::getName).collect(Collectors.toList());
            roomItems = String.join(", ", roomItemsNames);
        }
        if(!gameController.getMapController().getCurrentRoom().getAnimals().isEmpty()) {
            List<String> roomNPCsNames = gameController.getMapController().getCurrentRoom().getAnimals().stream()
                    .map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")")
                    .collect(Collectors.toList());
            roomNPCs = String.join(", ", roomNPCsNames);
        }
        System.out.println("You are in room " + gameController.getMapController().getCurrentRoom().getName() + "\n" +
                "Items: " + roomItems + "\n" +
                "NPCs: " + roomNPCs);
        return true;
    }
}
