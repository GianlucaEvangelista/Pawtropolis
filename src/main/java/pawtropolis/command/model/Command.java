package pawtropolis.command.model;
import pawtropolis.game.GameController;

public abstract class Command {

    protected final GameController gameController;

    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    public void notValidCommand() {
        System.out.println("Command isn't valid!");
    }

    public abstract void execute();
}
