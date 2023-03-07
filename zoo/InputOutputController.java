package zoo;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputOutputController {

    private static final Logger LOGGER = Logger.getLogger(InputOutputController.class.getName());
    String optionNotValid = "Valore inserito non valido!";

    public int displayMenuOptions() {
        Scanner input = new Scanner(System.in);
        int userSelection = 0;
        boolean displayMenuAgain;

        do {
            LOGGER.info("Digitare il numero della ricerca da effettuare");
            LOGGER.info("1 - Esemplare più alto");
            LOGGER.info("2 - Esemplare più basso");
            LOGGER.info("3 - Esemplare più pesante");
            LOGGER.info("4 - Esemplare più leggero");
            LOGGER.info("5 - Esemplare con la coda più lunga");
            LOGGER.info("6 - Esemplare con la maggiore apertura alare");
            LOGGER.info("7 - Chiudi il programma");
            try {
                userSelection = input.nextInt();
                displayMenuAgain = false;
            }
            catch (InputMismatchException exception) {
                LOGGER.info("Caratteri inseriti non validi!");
                input.nextLine();
                displayMenuAgain = true;
            }
        } while(displayMenuAgain);

        return userSelection;
    }

    public int displaySpeciesOptions() {
        Scanner input = new Scanner(System.in);
        int selectedSpecies = 0;
        boolean displayOptionsAgain;

        do {
            LOGGER.info("Per quale specie vuoi effettuare la ricerca (digitare il numero corrispondente)?");
            LOGGER.info("1 - Tigri");
            LOGGER.info("2 - Leoni");
            LOGGER.info("3 - Aquile");
            LOGGER.info("4 - Torna indietro");
            try {
                selectedSpecies = input.nextInt();
                displayOptionsAgain = false;
            }
            catch (InputMismatchException exception) {
                LOGGER.info("Caratteri inseriti non validi!");
                input.nextLine();
                displayOptionsAgain = true;
            }
        } while(displayOptionsAgain);

        return selectedSpecies;
    }


    public void tallestAnimalRequest(ZooController zooController) {
        switch(displaySpeciesOptions()) {
            case 1:
                LOGGER.info("La tigre più alta è " + zooController.getTallestAnimal(zooController.getTigers()).getName() + " (" + zooController.getTallestAnimal(zooController.getTigers()).getHeight() + " cm)");
                break;
            case 2:
                LOGGER.info("Il leone più alto è " + zooController.getTallestAnimal(zooController.getLions()).getName() + " (" + zooController.getTallestAnimal(zooController.getLions()).getHeight() + " cm)");
                break;
            case 3:
                LOGGER.info("L'aquila più alta è " + zooController.getTallestAnimal(zooController.getEagles()).getName() + " (" + zooController.getTallestAnimal(zooController.getEagles()).getHeight() + " cm)");
                break;
            case 4:
                break;
            default:
                LOGGER.info(optionNotValid);
        }
    }

    public void shortestAnimalRequest(ZooController zooController) {
        switch(displaySpeciesOptions()) {
            case 1:
                LOGGER.info("La tigre più bassa è " + zooController.getShortestAnimal(zooController.getTigers()).getName() + " (" + zooController.getShortestAnimal(zooController.getTigers()).getHeight() + " cm)");
                break;
            case 2:
                LOGGER.info("Il leone più basso è " + zooController.getShortestAnimal(zooController.getLions()).getName() + " (" + zooController.getShortestAnimal(zooController.getLions()).getHeight() + " cm)");
                break;
            case 3:
                LOGGER.info("L'aquila più bassa è " + zooController.getShortestAnimal(zooController.getEagles()).getName() + " (" + zooController.getShortestAnimal(zooController.getEagles()).getHeight() + " cm)");
                break;
            case 4:
                break;
            default:
                LOGGER.info(optionNotValid);
        }
    }

    public void heaviestAnimalRequest(ZooController zooController) {
        switch(displaySpeciesOptions()) {
            case 1:
                LOGGER.info("La tigre più pesante è " + zooController.getHeaviestAnimal(zooController.getTigers()).getName() + " (" + zooController.getHeaviestAnimal(zooController.getTigers()).getWeight() + " kg)");
                break;
            case 2:
                LOGGER.info("Il leone più pesante è " + zooController.getHeaviestAnimal(zooController.getLions()).getName() + " (" + zooController.getHeaviestAnimal(zooController.getLions()).getWeight() + " kg)");
                break;
            case 3:
                LOGGER.info("L'aquila più pesante è " + zooController.getHeaviestAnimal(zooController.getEagles()).getName() + " (" + zooController.getHeaviestAnimal(zooController.getEagles()).getWeight() + " kg)");
                break;
            case 4:
                break;
            default:
                LOGGER.info(optionNotValid);
        }
    }

    public void lightestAnimalRequest(ZooController zooController) {
        switch(displaySpeciesOptions()) {
            case 1:
                LOGGER.info("La tigre più leggera è " + zooController.getLightestAnimal(zooController.getTigers()).getName() + " (" + zooController.getLightestAnimal(zooController.getTigers()).getWeight() + " kg)");
                break;
            case 2:
                LOGGER.info("Il leone più leggero è " + zooController.getLightestAnimal(zooController.getLions()).getName() + " (" + zooController.getLightestAnimal(zooController.getLions()).getWeight() + " kg)");
                break;
            case 3:
                LOGGER.info("L'aquila più leggera è " + zooController.getLightestAnimal(zooController.getEagles()).getName() + " (" + zooController.getLightestAnimal(zooController.getEagles()).getWeight() + " kg)");
                break;
            case 4:
                break;
            default:
                LOGGER.info(optionNotValid);
        }
    }

    public void longestTailRequest(ZooController zooController) {
        Tailed longestTailAnimal = zooController.getLongestTailAnimal(zooController.getTailedAnimals());
        LOGGER.info("L'esemplare con la coda più lunga è " + longestTailAnimal.getName() + " (" + longestTailAnimal.getTailLength() + " cm).");
    }

    public void largestWingspanRequest(ZooController zooController) {
        Winged largestWingspanAnimal = zooController.getLargestWingspanAnimal(zooController.getWingedAnimals());
        LOGGER.info("L'esemplare con l'apertura alare maggiore è " + largestWingspanAnimal.getName() + " (" + largestWingspanAnimal.getWingspan() + " cm).");
    }

    public void displayWelcomeMessage() {
        LOGGER.info("Benvenuto nel sistema di gestione dello zoo");
    }

    public void displayClosingMessage() {
        LOGGER.info("Ricerca terminata!");
    }
}
