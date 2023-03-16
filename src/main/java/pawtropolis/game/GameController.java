package pawtropolis.game;
import pawtropolis.command.CommandController;
import pawtropolis.map.MapController;
import pawtropolis.player.Player;
public class GameController {

    private Player player;
    private MapController mapController;
    private InputController inputController;
    private CommandController commandController;
    private boolean wantToEndGame;

    public GameController() {
        this.mapController = new MapController(this);
        this.inputController = new InputController();
        this.commandController = new CommandController(this);
        this.wantToEndGame = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MapController getMapController() {
        return mapController;
    }

    public void setMapController(MapController mapController) {
        this.mapController = mapController;
    }

    public InputController getInputController() {
        return inputController;
    }

    public void setInputController(InputController inputController) {
        this.inputController = inputController;
    }

    public CommandController getCommandController() {
        return commandController;
    }

    public boolean isWantToEndGame() {
        return wantToEndGame;
    }

    public void setWantToEndGame(boolean wantToEndGame) {
        this.wantToEndGame = wantToEndGame;
    }

    public void setCommandController(CommandController commandController) {
        this.commandController = commandController;
    }

    public void endGame() {
        wantToEndGame = true;
    }

    public void runGame() {
        player = new Player(inputController.getPlayerName());
        do {
            commandController.executeCommand(this);
        } while(!wantToEndGame);
        System.exit(0);
    }
}
