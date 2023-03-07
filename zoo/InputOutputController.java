package zoo;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputOutputController {

    private static final Logger LOGGER = Logger.getLogger(InputOutputController.class.getName());

    public int displayMenuOptions() {
        Scanner input = new Scanner(System.in);
        int userSelection = 0;
        boolean displayMenuAgain = false;

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
        boolean displayOptionsAgain = false;

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
}
