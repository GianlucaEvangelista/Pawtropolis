package zoo;
import java.util.List;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Operations {

    private static final Logger LOGGER = Logger.getLogger(Operations.class.getName());

    // metodo animale più alto
    public Animal tallest(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingDouble(Animal::getHeight)).orElse(null);
    }

    // metodo animale più basso
    public Animal shortest(List<Animal> animals) {
        return animals.stream().min(Comparator.comparingDouble(Animal::getHeight)).orElse(null);
    }

    // metodo animale più pesante
    public Animal heaviest(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingDouble(Animal::getWeight)).orElse(null);
    }

    // metodo animale più leggero
    public Animal lightest(List<Animal> animals) {
        return animals.stream().min(Comparator.comparingDouble(Animal::getWeight)).orElse(null);
    }

    // metodo animale con la coda più lunga
    public Tailed longestTail(List<Tailed> taileds) {
        return taileds.stream().max(Comparator.comparingDouble(Tailed::getTailLength)).orElse(null);
    }

    // metodo animale con maggiore apertura alare
    public Winged largestWingspan(List<Winged> wingeds) {
        return wingeds.stream().max(Comparator.comparingDouble(Winged::getWingspan)).orElse(null);
    }

    // metodo menu di selezione ricerca
    public int searchMenu() {
        Scanner input = new Scanner(System.in);
        int search = 0;
        boolean again = false;

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
                search = input.nextInt();
                again = false;
            }
            catch (InputMismatchException exception) {
                LOGGER.info("Caratteri inseriti non validi!");
                input.nextLine();
                again = true;
            }
        } while(again);

        return search;
    }

    // metodo selezione specie da interrogare
    public int speciesSelection() {
        Scanner input = new Scanner(System.in);
        int selectedSpecies = 0;
        boolean again = false;

        do {
            LOGGER.info("Per quale specie vuoi effettuare la ricerca (digitare il numero corrispondente)?");
            LOGGER.info("1 - Tigri");
            LOGGER.info("2 - Leoni");
            LOGGER.info("3 - Aquile");
            LOGGER.info("4 - Torna indietro");
            try {
                selectedSpecies = input.nextInt();
                again = false;
            }
            catch (InputMismatchException exception) {
                LOGGER.info("Caratteri inseriti non validi!");
                input.nextLine();
                again = true;
            }
        } while(again);

        return selectedSpecies;
    }
}
