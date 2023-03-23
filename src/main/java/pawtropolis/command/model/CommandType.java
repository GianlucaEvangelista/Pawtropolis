package pawtropolis.command.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CommandType {

    GO("go", GoCommand.class),
    LOOK("look", LookCommand.class),
    BAG("bag", BagCommand.class),
    GET("get", GetCommand.class),
    DROP("drop", DropCommand.class),
    EXIT("exit", ExitCommand.class),
    UNKNOWN("", UnknownCommand.class);

    private final String commandString;
    private final Class<? extends Command> commandClass;

    public static CommandType fromString(String commandNameInput) {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> commandType.commandString.equals(commandNameInput)).findFirst()
                .orElse(UNKNOWN);
    }
}
