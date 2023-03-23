package pawtropolis.command;
import lombok.*;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;
import pawtropolis.game.InputController;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CommandController {

    private GameController gameController;

    public void executeCommand(GameController gameController) {
        boolean commandIsValid = false;
        do {
            List<String> chosenCommand = InputController.getCommand();
            String commandNameInput = chosenCommand.get(0);
            Command command = CommandFactory.createCommand(gameController, commandNameInput);
            if(command != null) {
                commandIsValid = command.execute(chosenCommand);
            }
        } while(!commandIsValid);
    }

}
