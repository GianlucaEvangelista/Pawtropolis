package pawtropolis.command.model;

import pawtropolis.game.GameController;

public class UnknownCommand extends Command {
    public UnknownCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, String[] chosenCommand) {
        System.out.println("Command not valid!");
        return false;
    }
}
