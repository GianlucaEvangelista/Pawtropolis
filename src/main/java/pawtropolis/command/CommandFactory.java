package pawtropolis.command;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.command.model.*;
import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component
public class CommandFactory {

    private final Map<CommandType, Command> commandMap = new EnumMap<>(CommandType.class);
    private final List<Command> commandList;

    @Autowired
    private CommandFactory(List<Command> commandList) {
        this.commandList = commandList;
    }

    @PostConstruct
    public void setCommandMap() {
        commandList.forEach(command -> {
            CommandType commandType = CommandType.fromCommandClass(command.getClass());
            commandMap.put(commandType, command);
        });
    }

    public Command getCommandFromString(String commandNameInput) {
        CommandType commandType = commandNameInput == null ? CommandType.UNKNOWN : CommandType.fromString(commandNameInput);
        return commandMap.get(commandType);
    }
}
