package pawtropolis.command;
import lombok.experimental.UtilityClass;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;

@UtilityClass
public final class CommandFactory {

    public static Command createCommand(GameController gameController, String commandNameInput) {
        if(commandNameInput == null) {
            return CommandType.UNKNOWN.createCommand(gameController);
        }
        CommandType commandType = CommandType.fromString(commandNameInput);
        return commandType.createCommand(gameController);
    }
}
