package pawtropolis.game;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import pawtropolis.command.CommandController;
import pawtropolis.map.MapController;
import pawtropolis.player.Player;

@Getter
@Setter
public class GameController {

    private Player player;
    private MapController mapController;
    private boolean wantToEndGame;

    @Autowired
    public GameController(Player player, MapController mapController) {
        this.player = player;
        this.mapController = mapController;
        this.wantToEndGame = false;
    }

    public void endGame() {
        wantToEndGame = true;
    }

    public void runGame() {
        player.setName(InputController.getPlayerName());
        do {
            CommandController.executeCommand();
        } while(!wantToEndGame);
        System.exit(0);
    }
}
