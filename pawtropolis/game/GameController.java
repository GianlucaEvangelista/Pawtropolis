package pawtropolis.game;
import pawtropolis.map.MapController;
import pawtropolis.player.Player;

public class GameController {

    private Player player;
    private MapController mapController;
    private InputController inputController;

    public GameController() {
        this.mapController = new MapController();
        this.inputController = new InputController();
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

    public void runGame() {
        player = new Player(inputController.getPlayerName());
    }
}
