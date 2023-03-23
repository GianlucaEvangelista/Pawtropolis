package pawtropolis.command;
import lombok.experimental.UtilityClass;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;

@UtilityClass
public final class CommandFactory {

    public static Command createCommand(GameController gameController, String commandNameInput) {
        try {
            if (commandNameInput == null) {
                return CommandType.UNKNOWN.getCommandClass().getConstructor(GameController.class).newInstance(gameController);
            }
            CommandType commandType = CommandType.fromString(commandNameInput);
            return commandType.getCommandClass().getConstructor(GameController.class).newInstance(gameController);
        } catch (ReflectiveOperationException e){
            return null;
        }
    }
}
