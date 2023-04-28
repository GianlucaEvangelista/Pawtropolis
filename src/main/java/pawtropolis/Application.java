package pawtropolis;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pawtropolis.config.AppConfiguration;
import pawtropolis.game.GameController;
import pawtropolis.zoo.*;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        GameController gameController = context.getBean(GameController.class);
        gameController.runGame();
        //ZooApp.zooRequests();
    }
}
