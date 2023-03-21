package pawtropolis.command;
import lombok.experimental.UtilityClass;
import pawtropolis.command.model.*;
import pawtropolis.game.GameController;
import java.util.List;

@UtilityClass
public final class CommandFactory {

    public static Command createCommand(GameController gameController, List<String> chosenCommand) {
        if(chosenCommand.isEmpty() || chosenCommand.get(0) == null) {
            return null;
        }
        CommandType commandType = CommandType.convertStringToCommand(chosenCommand.get(0));
        return commandType.createCommand(gameController);
    }
}
