package pawtropolis.command;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;
import pawtropolis.game.InputController;
import java.util.List;

public class CommandController {

    private GameController gameController;

    public CommandController(GameController gameController) {
        this.gameController = gameController;
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
            List<String> chosenCommand = InputController.getCommand();
            Command command = CommandFactory.createCommand(gameController, chosenCommand);
            if(command != null) {
                commandIsValid = command.execute(gameController, chosenCommand);
            }
        } while(!commandIsValid);
    }

}
