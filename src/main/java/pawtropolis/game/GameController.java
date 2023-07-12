package pawtropolis.game;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.command.CommandController;
import pawtropolis.game.console.InputController;
import pawtropolis.map.MapController;
import pawtropolis.game.model.Player;
import pawtropolis.persistence.service.PlayerService;
import pawtropolis.utils.SqlExecutor;
import java.util.Optional;

@Getter
@Setter
@Component
public class GameController {

    private Player player;
    private MapController mapController;
    private CommandController commandController;
    private boolean wantToEndGame;
    private PlayerService playerService;
    private SqlExecutor sqlExecutor;

    @Autowired
    public GameController(Player player, MapController mapController, CommandController commandController, PlayerService playerService, SqlExecutor sqlExecutor) {
        this.player = player;
        this.mapController = mapController;
        this.commandController = commandController;
        this.playerService = playerService;
        this.wantToEndGame = false;
        this.sqlExecutor = sqlExecutor;
    }

    public void endGame() {
        wantToEndGame = true;
    }

    public void runGame() {
        System.out.println("Welcome to Pawtropolis!");
        choosePlayer();
        do {
            this.commandController.executeCommand();
        } while(!wantToEndGame);
        System.exit(0);
    }

    public void choosePlayer() {
        boolean validPlayer = false;
        do {
            System.out.println("Select your player: NEW / LOAD");
            String userChoice = InputController.getInputString().toLowerCase();
            switch (userChoice) {
                case "new" -> {
                    this.player.askPlayerName(playerService.getPlayerEntityNames());
                    Integer playerId = playerService.savePlayer(this.player).getId();
                    player.setId(playerId);
                    sqlExecutor.executeSqlScript(player.getId());
                    validPlayer = true;
                }
                case "load" -> {
                    Optional<Player> optionalPlayer = playerService.loadPlayer();
                    if(optionalPlayer.isPresent()) {
                        setPlayer(optionalPlayer.get());
                        validPlayer = true;
                    }
                }
                default -> System.out.println("Invalid input!");
            }
        }while(!validPlayer);

    }
}
