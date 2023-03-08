package pawtropolis;
import pawtropolis.zoo.*;
import java.time.LocalDate;
import java.util.logging.Logger;

public class Application {
    public static void main(String[] args) {
        zooRequests();
    }

    public static void zooRequests() {
        Logger logger = Logger.getLogger(Application.class.getName());
        ZooController zooController = new ZooController();

        zooController.addAnimal(new Tiger("Black", "lamb", 7, LocalDate.of(2022,4,5), 220.30, 92.70, 82.10));
        zooController.addAnimal(new Tiger("Zelda", "rabbit", 8, LocalDate.of(2021,9,10), 242.80, 87.90, 81.80));
        zooController.addAnimal(new Tiger("Arya", "veal", 10, LocalDate.of(2020,7,11), 260.00, 94.00, 86.50));
        zooController.addAnimal(new Lion("Leo", "pork", 7, LocalDate.of(2019,6,27), 190.00, 118.50, 91.20));
        zooController.addAnimal(new Lion("Asia", "beef", 5, LocalDate.of(2020,12,7), 172.00, 109.20, 84.30));
        zooController.addAnimal(new Lion("Simba", "horse", 6, LocalDate.of(2021,3,10), 184.60, 112.50, 87.40));
        zooController.addAnimal(new Lion("Argo", "lamb", 9, LocalDate.of(2020,6,23), 192.10, 116.80, 92.10));
        zooController.addAnimal(new Eagle("Sky", "duck", 3, LocalDate.of(2021,4,20), 4.50, 81.20, 210.10));
        zooController.addAnimal(new Eagle("White", "goose", 4, LocalDate.of(2019,2,5), 4.30, 80.50, 212.30));
        zooController.addAnimal(new Eagle("Jack", "chicken", 2, LocalDate.of(2022,7,20), 3.90, 77.20, 182.70));


        InputOutputController inputOutputController = new InputOutputController();
        inputOutputController.displayWelcomeMessage();
        boolean closeProgram = false;

        do {
            switch(inputOutputController.displayMenuOptions()) {
                case 1:
                    inputOutputController.tallestAnimalRequest(zooController);
                    break;
                case 2:
                    inputOutputController.shortestAnimalRequest(zooController);
                    break;
                case 3:
                    inputOutputController.heaviestAnimalRequest(zooController);
                    break;
                case 4:
                    inputOutputController.lightestAnimalRequest(zooController);
                    break;
                case 5:
                    inputOutputController.longestTailRequest(zooController);
                    break;
                case 6:
                    inputOutputController.largestWingspanRequest(zooController);
                    break;
                case 7:
                    closeProgram = true;
                    break;
                default:
                    logger.info(InputOutputController.OPTION_NOT_VALID);
            }
        } while(!closeProgram);

        inputOutputController.displayClosingMessage();
        System.exit(0);
    }
}
