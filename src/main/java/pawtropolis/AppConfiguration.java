package pawtropolis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pawtropolis.game.GameController;
import pawtropolis.map.MapController;
import pawtropolis.player.Player;

@Configuration
@ComponentScan(basePackages = "pawtropolis")
public class AppConfiguration {

    @Bean
    public GameController gameController(Player player, MapController mapController) {
        return new GameController(player, mapController);
    }
}
