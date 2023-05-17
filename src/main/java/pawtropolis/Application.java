package pawtropolis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pawtropolis.config.AppConfiguration;
import pawtropolis.game.GameController;
import pawtropolis.zoo.*;

@SpringBootApplication
public class Application implements ApplicationRunner {

    private final GameController gameController;

    @Autowired
    public Application(GameController gameController) {
        this.gameController = gameController;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppConfiguration.class);
        app.run(args);
        //ZooApp.zooRequests();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        gameController.runGame();
    }
}
