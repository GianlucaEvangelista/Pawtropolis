package pawtropolis.command;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.model.*;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component
public class CommandFactory {

    private static final Map<CommandType, Command> commandMap = new EnumMap<>(CommandType.class);
    private final List<Command> commandList;

    @Autowired
    private CommandFactory(List<Command> commandList) {
        this.commandList = commandList;
        this.setCommandMap();
    }

    private void setCommandMap() {
        commandList.forEach(command -> {
            CommandType commandType = CommandType.fromCommandClass(command.getClass());
            commandMap.put(commandType, command);
        });
    }

    public static Command getCommandFromString(String commandNameInput) {
        CommandType commandType = commandNameInput == null ? CommandType.UNKNOWN : CommandType.fromString(commandNameInput);
        return commandMap.get(commandType);
    }
}
