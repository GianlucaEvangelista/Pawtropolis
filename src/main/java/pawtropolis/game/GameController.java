package pawtropolis.game;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import pawtropolis.game.command.CommandController;
import pawtropolis.map.MapController;
import pawtropolis.game.model.Player;

@Getter
@Setter
public class GameController {

    private Player player;
    private MapController mapController;
    private CommandController commandController;
    private boolean wantToEndGame;

    @Autowired
    public GameController(Player player, MapController mapController, CommandController commandController) {
        this.player = player;
        this.mapController = mapController;
        this.commandController = commandController;
        this.wantToEndGame = false;
    }

    public void endGame() {
        wantToEndGame = true;
    }

    public void runGame() {
        System.out.println("Welcome to Pawtropolis!");
        do {
            this.commandController.executeCommand();
        } while(!wantToEndGame);
        System.exit(0);
    }
}
