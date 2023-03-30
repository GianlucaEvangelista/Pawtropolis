package pawtropolis.command;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.model.*;
import pawtropolis.game.InputController;
import java.util.List;

@Getter
@Setter
@Component
public class CommandController {

    private CommandFactory commandFactory;

    private CommandController() {}

    @Autowired
    private void setCommandFactory(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void executeCommand() {
        boolean commandIsValid = false;
        do {
            List<String> commandInput = InputController.getCommand();
            String commandNameInput = commandInput.get(0);
            String commandArgInput = null;
            if(commandInput.size() > 1) {
                commandArgInput = commandInput.get(1);
            }
            Command command = CommandFactory.getCommandFromString(commandNameInput);
            if(command != null) {
                commandIsValid = command.execute(commandArgInput);
            }
        } while(!commandIsValid);
    }

}
