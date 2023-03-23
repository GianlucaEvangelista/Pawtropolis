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
            Command command = CommandFactory.createCommand(gameController, chosenCommand);
            if(command != null) {
                commandIsValid = command.execute(chosenCommand);
            }
        } while(!commandIsValid);
    }

}
