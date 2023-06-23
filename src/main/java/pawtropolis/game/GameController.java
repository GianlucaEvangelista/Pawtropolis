package pawtropolis.game;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.command.CommandController;
import pawtropolis.map.MapController;
import pawtropolis.game.model.Player;
import pawtropolis.persistence.service.PlayerService;

@Getter
@Setter
@Component
public class GameController {

    private Player player;
    private MapController mapController;
    private CommandController commandController;
    private boolean wantToEndGame;
    private PlayerService playerService;

    @Autowired
    public GameController(Player player, MapController mapController, CommandController commandController, PlayerService playerService) {
        this.player = player;
        this.mapController = mapController;
        this.commandController = commandController;
        this.playerService = playerService;
        this.wantToEndGame = false;
    }

    public void endGame() {
        wantToEndGame = true;
    }

    public void runGame() {
        System.out.println("Welcome to Pawtropolis!");
        playerService.savePlayer(this.player);
        do {
            this.commandController.executeCommand();
        } while(!wantToEndGame);
        System.exit(0);
    }
}
