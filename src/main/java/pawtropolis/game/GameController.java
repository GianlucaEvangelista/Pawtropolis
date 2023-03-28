package pawtropolis.game;
import lombok.Getter;
import lombok.Setter;
import pawtropolis.command.CommandController;
import pawtropolis.map.MapController;
import pawtropolis.player.Player;

@Getter
@Setter
public class GameController {

    private Player player;
    private MapController mapController;
    private boolean wantToEndGame;

    public GameController() {
        this.mapController = new MapController();
        this.wantToEndGame = false;
    }

    public void endGame() {
        wantToEndGame = true;
    }

    public void runGame() {
        player = new Player(InputController.getPlayerName());
        do {
            CommandController.executeCommand(this);
        } while(!wantToEndGame);
        System.exit(0);
    }
}
