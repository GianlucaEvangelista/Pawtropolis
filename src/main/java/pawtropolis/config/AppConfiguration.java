package pawtropolis.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pawtropolis.command.CommandController;
import pawtropolis.game.GameController;
import pawtropolis.map.MapController;
import pawtropolis.player.Player;

@Configuration
@ComponentScan(basePackages = "pawtropolis")
public class AppConfiguration {

    @Bean
    public GameController gameController(Player player, MapController mapController, CommandController commandController) {
        return new GameController(player, mapController, commandController);
    }
}
