package pawtropolis.game.command.model;
import pawtropolis.game.GameController;

public abstract class Command {

    protected final GameController gameController;

    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    public static void notValidArg() {
        System.out.println("Command parameter isn't valid!");
    }

    public abstract void execute();
}
