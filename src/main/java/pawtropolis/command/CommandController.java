package pawtropolis.command;
import lombok.*;
import org.springframework.stereotype.Component;
import pawtropolis.command.model.*;
import pawtropolis.game.InputController;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Component
public class CommandController {

    private static final String MENU = """
                Write one of the following commands:
                - go north/go east/go south/go west: change room
                - look: get a description of the current room
                - bag: get the list of the items inside the bag
                - get + item's name: put the item inside the bag
                - drop + item's name: drop the item
                - exit: end the game""";


    public void executeCommand() {
        List<String> commandInput = getCommandFromInput();
        String commandNameInput = commandInput.get(0);
        String commandArgInput = commandInput.size() > 1 ? commandInput.get(1) : null;
        Command command = CommandFactory.getCommandFromString(commandNameInput);
        if(command instanceof CommandWithArg commandWithArg) {
            commandWithArg.setCommandArg(commandArgInput);
            command.execute();
        } else if(commandArgInput == null) {
            command.execute();
        } else {
            Command.notValidArg();
        }
    }

    public List<String> getCommandFromInput() {
        System.out.println(MENU);
        String commandInputString = InputController.getInputString();
        return Arrays.asList(commandInputString.split(" ", 2));
    }
}
