package pawtropolis.command.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pawtropolis.game.GameController;
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

    public static CommandType convertStringToCommand(String commandString) {
        for (CommandType commandType : values()) {
            if (commandType.commandString.equals(commandString)) {
                return commandType;
            }
        }
        return UNKNOWN;
    }
}
