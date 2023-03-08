package zoo;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputOutputController {

    private static final Logger LOGGER = Logger.getLogger(InputOutputController.class.getName());
    String optionNotValid = "Option not valid!";

    public int displayMenuOptions() {
        Scanner input = new Scanner(System.in);
        int userSelection = 0;
        boolean displayMenuAgain;

        do {
            LOGGER.info("Choose the number of the request you want to make");
            LOGGER.info("1 - The tallest animal");
            LOGGER.info("2 - The shortest animal");
            LOGGER.info("3 - The heaviest animal");
            LOGGER.info("4 - The lightest animal");
            LOGGER.info("5 - The animal with the longest tail");
            LOGGER.info("6 - The animal with the largest wingspan");
            LOGGER.info("7 - Close the program");
            try {
                userSelection = input.nextInt();
                displayMenuAgain = false;
            }
            catch (InputMismatchException exception) {
                LOGGER.info("Selected characters not valid!");
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
            LOGGER.info("For which species do you want to make your request (select the number)?");
            LOGGER.info("1 - Tigers");
            LOGGER.info("2 - Lions");
            LOGGER.info("3 - Eagles");
            LOGGER.info("4 - Go back");
            try {
                selectedSpecies = input.nextInt();
                displayOptionsAgain = false;
            }
            catch (InputMismatchException exception) {
                LOGGER.info("Selected characters not valid!");
                input.nextLine();
                displayOptionsAgain = true;
            }
        } while(displayOptionsAgain);

        return selectedSpecies;
    }


    public void tallestAnimalRequest(ZooController zooController) {
        switch(displaySpeciesOptions()) {
            case 1:
                LOGGER.info("The tallest tiger is " + zooController.getTallestAnimal(zooController.getTigers()).getName() + " (" + zooController.getTallestAnimal(zooController.getTigers()).getHeight() + " cm)");
                break;
            case 2:
                LOGGER.info("The tallest lion is " + zooController.getTallestAnimal(zooController.getLions()).getName() + " (" + zooController.getTallestAnimal(zooController.getLions()).getHeight() + " cm)");
                break;
            case 3:
                LOGGER.info("The tallest eagle is " + zooController.getTallestAnimal(zooController.getEagles()).getName() + " (" + zooController.getTallestAnimal(zooController.getEagles()).getHeight() + " cm)");
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
                LOGGER.info("The shortest tiger is " + zooController.getShortestAnimal(zooController.getTigers()).getName() + " (" + zooController.getShortestAnimal(zooController.getTigers()).getHeight() + " cm)");
                break;
            case 2:
                LOGGER.info("The shortest lion is " + zooController.getShortestAnimal(zooController.getLions()).getName() + " (" + zooController.getShortestAnimal(zooController.getLions()).getHeight() + " cm)");
                break;
            case 3:
                LOGGER.info("The shortest eagle is " + zooController.getShortestAnimal(zooController.getEagles()).getName() + " (" + zooController.getShortestAnimal(zooController.getEagles()).getHeight() + " cm)");
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
                LOGGER.info("The heaviest tiger is " + zooController.getHeaviestAnimal(zooController.getTigers()).getName() + " (" + zooController.getHeaviestAnimal(zooController.getTigers()).getWeight() + " kg)");
                break;
            case 2:
                LOGGER.info("The heaviest lion is " + zooController.getHeaviestAnimal(zooController.getLions()).getName() + " (" + zooController.getHeaviestAnimal(zooController.getLions()).getWeight() + " kg)");
                break;
            case 3:
                LOGGER.info("The heaviest eagle is " + zooController.getHeaviestAnimal(zooController.getEagles()).getName() + " (" + zooController.getHeaviestAnimal(zooController.getEagles()).getWeight() + " kg)");
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
                LOGGER.info("The lightest tiger is " + zooController.getLightestAnimal(zooController.getTigers()).getName() + " (" + zooController.getLightestAnimal(zooController.getTigers()).getWeight() + " kg)");
                break;
            case 2:
                LOGGER.info("The lightest lion is " + zooController.getLightestAnimal(zooController.getLions()).getName() + " (" + zooController.getLightestAnimal(zooController.getLions()).getWeight() + " kg)");
                break;
            case 3:
                LOGGER.info("The lightest eagle is " + zooController.getLightestAnimal(zooController.getEagles()).getName() + " (" + zooController.getLightestAnimal(zooController.getEagles()).getWeight() + " kg)");
                break;
            case 4:
                break;
            default:
                LOGGER.info(optionNotValid);
        }
    }

    public void longestTailRequest(ZooController zooController) {
        Tailed longestTailAnimal = zooController.getLongestTailAnimal(zooController.getTailedAnimals());
        LOGGER.info("The animal with the longest tail is " + longestTailAnimal.getName() + " (" + longestTailAnimal.getTailLength() + " cm).");
    }

    public void largestWingspanRequest(ZooController zooController) {
        Winged largestWingspanAnimal = zooController.getLargestWingspanAnimal(zooController.getWingedAnimals());
        LOGGER.info("The animal with the largest wingspan is " + largestWingspanAnimal.getName() + " (" + largestWingspanAnimal.getWingspan() + " cm).");
    }

    public void displayWelcomeMessage() {
        LOGGER.info("Welcome to the zoo management system!");
    }

    public void displayClosingMessage() {
        LOGGER.info("Goodbye!");
    }
}
