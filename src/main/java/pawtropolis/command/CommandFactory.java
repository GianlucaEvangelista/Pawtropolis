package pawtropolis.command;
import lombok.experimental.UtilityClass;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;

@UtilityClass
public final class CommandFactory {

    public static Command createCommand(GameController gameController, String commandNameInput) {
        if(commandNameInput == null) {
            return null;
        }
        CommandType commandType = CommandType.convertStringToCommand(commandNameInput);
        return commandType.createCommand(gameController);
    }
}
