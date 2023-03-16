package pawtropolis.command;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;
import pawtropolis.game.InputController;
import java.util.List;

public class CommandController {

    private InputController inputController;
    private GameController gameController;

    public CommandController(GameController gameController) {
        this.inputController = new InputController();
        this.gameController = gameController;
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


    public void executeCommand(GameController gameController) {
        boolean commandIsValid = false;
        do {
            List<String> chosenCommand = inputController.getCommand();
            Command command = CommandFactory.createCommand(gameController, chosenCommand);
            if(command != null) {
                commandIsValid = command.execute(gameController, chosenCommand);
            }
        } while(!commandIsValid);
    }

}
