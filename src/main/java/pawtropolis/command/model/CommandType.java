package pawtropolis.command.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pawtropolis.game.GameController;
import java.util.Arrays;
import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum CommandType {

    GO("go", GoCommand::new),
    LOOK("look", LookCommand::new),
    BAG("bag", BagCommand::new),
    GET("get", GetCommand::new),
    DROP("drop", DropCommand::new),
    EXIT("exit", ExitCommand::new),
    UNKNOWN("", UnknownCommand::new);

    private final String commandString;
    private final Function<GameController, Command> commandConstructor;

    public Command createCommand(GameController gameController) {
        return commandConstructor.apply(gameController);
    }

    public static CommandType fromString(String commandNameInput) {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> commandType.commandString.equals(commandNameInput)).findFirst()
                .orElse(UNKNOWN);
    }
}
