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

    public void executeCommand(GameController gameController) {
        boolean commandIsValid;
        do {
            String[] chosenCommand = inputController.getCommand();
            Command command = commandFactory.createCommand(gameController, chosenCommand);
            commandIsValid = command.execute(gameController, chosenCommand);
        } while(!commandIsValid);
    }

}
