package pawtropolis.command;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;

public class CommandFactory {

    public Command createCommand(GameController gameController, String commandName) {
        switch (commandName.toLowerCase()) {
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
            default:
                return null;
        }
    }
}
