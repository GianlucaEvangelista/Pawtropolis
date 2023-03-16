package pawtropolis.command;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;

public class CommandFactory {

    public Command createCommand(GameController gameController, String[] chosenCommand) {
        switch (chosenCommand[0]) {
            case "go":
                if(chosenCommand.length > 1 && (chosenCommand[1].equals("north") || chosenCommand[1].equals("east") ||
                        chosenCommand[1].equals("south") || chosenCommand[1].equals("west"))) {
                    return new GoCommand(gameController, chosenCommand[1]);
                } else {
                    return null;
                }
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
