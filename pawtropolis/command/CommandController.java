package pawtropolis.command;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;
import pawtropolis.game.InputController;

public class CommandController {

    private InputController inputController;
    private GameController gameController;
    private CommandFactory commandFactory;

    public CommandController(GameController gameController) {
        this.inputController = new InputController();
        this.gameController = gameController;
        this.commandFactory = new CommandFactory();
    }

    public InputController getInputController() {
        return inputController;
    }

    public void setInputController(InputController inputController) {
        this.inputController = inputController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public CommandFactory getCommandFactory() {
        return commandFactory;
    }

    public void setCommandFactory(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public boolean executeCommand(GameController gameController) {
        boolean commandIsValid = false;
        do {
            String[] chosenCommand = inputController.getCommand();
            if(chosenCommand[0].equals("exit")) {
                System.out.println("Goodbye " + gameController.getPlayer().getName() + "!");
                return true;
            }
            Command command = commandFactory.createCommand(gameController, chosenCommand[0]);
            if(command != null) {
                commandIsValid = command.execute(gameController, chosenCommand);
            } else {
                System.out.println("Command not valid!");
            }
        } while(!commandIsValid);
        return false;
    }

}
