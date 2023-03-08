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
                Tiger tallestTiger = zooController.getTallestAnimal(zooController.getTigers());
                LOGGER.info("The tallest tiger is " + tallestTiger.getName() + " (" + tallestTiger.getHeight() + " cm)");
                break;
            case 2:
                Lion tallestLion = zooController.getTallestAnimal(zooController.getLions());
                LOGGER.info("The tallest lion is " + tallestLion.getName() + " (" + tallestLion.getHeight() + " cm)");
                break;
            case 3:
                Eagle tallestEagle = zooController.getTallestAnimal(zooController.getEagles());
                LOGGER.info("The tallest eagle is " + tallestEagle.getName() + " (" + tallestEagle.getHeight() + " cm)");
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
                Tiger shortestTiger = zooController.getShortestAnimal(zooController.getTigers());
                LOGGER.info("The shortest tiger is " + shortestTiger.getName() + " (" + shortestTiger.getHeight() + " cm)");
                break;
            case 2:
                Lion shortestLion = zooController.getShortestAnimal(zooController.getLions());
                LOGGER.info("The shortest lion is " + shortestLion.getName() + " (" + shortestLion.getHeight() + " cm)");
                break;
            case 3:
                Eagle shortestEagle = zooController.getShortestAnimal(zooController.getEagles());
                LOGGER.info("The shortest eagle is " + shortestEagle.getName() + " (" + shortestEagle.getHeight() + " cm)");
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
                Tiger heaviestTiger = zooController.getHeaviestAnimal(zooController.getTigers());
                LOGGER.info("The heaviest tiger is " + heaviestTiger.getName() + " (" + heaviestTiger.getWeight() + " kg)");
                break;
            case 2:
                Lion heaviestLion = zooController.getHeaviestAnimal(zooController.getLions());
                LOGGER.info("The heaviest lion is " + heaviestLion.getName() + " (" + heaviestLion.getWeight() + " kg)");
                break;
            case 3:
                Eagle heaviestEagle = zooController.getHeaviestAnimal(zooController.getEagles());
                LOGGER.info("The heaviest eagle is " + heaviestEagle.getName() + " (" + heaviestEagle.getWeight() + " kg)");
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
                Tiger lightestTiger = zooController.getLightestAnimal(zooController.getTigers());
                LOGGER.info("The lightest tiger is " + lightestTiger.getName() + " (" + lightestTiger.getWeight() + " kg)");
                break;
            case 2:
                Lion lightestLion = zooController.getLightestAnimal(zooController.getLions());
                LOGGER.info("The lightest lion is " + lightestLion.getName() + " (" + lightestLion.getWeight() + " kg)");
                break;
            case 3:
                Eagle lightestEagle = zooController.getLightestAnimal(zooController.getEagles());
                LOGGER.info("The lightest eagle is " + lightestEagle.getName() + " (" + lightestEagle.getWeight() + " kg)");
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
