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
            List<String> commandInput = InputController.getCommand();
            String commandNameInput = commandInput.get(0);
            String commandArgInput = null;
            if(commandInput.size() > 1) {
                commandArgInput = commandInput.get(1);
            }
            Command command = CommandFactory.createCommand(gameController, commandNameInput);
            if(command != null) {
                commandIsValid = command.execute(commandArgInput);
            }
        } while(!commandIsValid);
    }

}
