package pawtropolis.command;
import lombok.*;
import org.springframework.stereotype.Component;
import pawtropolis.command.model.*;
import pawtropolis.game.InputController;
import java.util.List;

@Getter
@Setter
@Component
public class CommandController {

    private CommandController() {}

    public void executeCommand() {
        List<String> commandInput = InputController.getCommand();
        String commandNameInput = commandInput.get(0);
        String commandArgInput = commandInput.size() > 1 ? commandInput.get(1) : null;
        Command command = CommandFactory.getCommandFromString(commandNameInput);
        if(command instanceof CommandWithArg commandWithArg) {
            commandWithArg.setCommandArg(commandArgInput);
            command.execute();
        } else if(commandArgInput == null) {
            command.execute();
        } else {
            command.notValidCommand();
        }
    }
}
