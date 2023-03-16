package pawtropolis.command;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;
import java.util.List;

public final class CommandFactory {

    private CommandFactory() {}

    public static Command createCommand(GameController gameController, List<String> chosenCommand) {
        if(chosenCommand.get(0) == null) {
            return null;
        }
        switch (chosenCommand.get(0)) {
            case "go":
                return new GoCommand(gameController);
            case "look":
                return new LookCommand(gameController);
            case "bag":
                return new BagCommand(gameController);
            case "get":
                return new GetCommand(gameController);
            case "drop":
                return new DropCommand(gameController);
            case "exit":
                return new ExitCommand(gameController);
            default:
                return new UnknownCommand(gameController);
        }
    }
}
