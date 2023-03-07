package zoo;
import java.util.*;
import java.util.logging.Logger;

public class ZooController {

    private static final Logger LOGGER = Logger.getLogger(ZooController.class.getName());
    private List<Animal> tigers;
    private List<Animal> lions;
    private List<Animal> eagles;
    private List<Tailed> tailedAnimals;
    private List<Winged> wingedAnimals;

    public ZooController() {
        this.tigers = new ArrayList<>();
        this.lions = new ArrayList<>();
        this.eagles = new ArrayList<>();
        this.tailedAnimals = new ArrayList<>();
        this.wingedAnimals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        if(animal.getSpecies().equals("tigre")) {
            tigers.add(animal);
            tailedAnimals.add((Tailed) animal);
        } else if(animal.getSpecies().equals("leone")) {
            lions.add(animal);
            tailedAnimals.add((Tailed) animal);
        } else if(animal.getSpecies().equals("aquila")){
            eagles.add(animal);
            wingedAnimals.add((Winged) animal);
        }
    }

    public List<Animal> getTigers() {
        return tigers;
    }

    public List<Animal> getLions() {
        return lions;
    }

    public List<Animal> getEagles() {
        return eagles;
    }

    public List<Tailed> getTailedAnimals() {
        return tailedAnimals;
    }

    public List<Winged> getWingedAnimals() {
        return wingedAnimals;
    }

    public Animal getTallestAnimal(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingDouble(Animal::getHeight)).orElse(null);
    }

    public Animal getShortestAnimal(List<Animal> animals) {
        return animals.stream().min(Comparator.comparingDouble(Animal::getHeight)).orElse(null);
    }

    public Animal getHeaviestAnimal(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingDouble(Animal::getWeight)).orElse(null);
    }

    public Animal getLightestAnimal(List<Animal> animals) {
        return animals.stream().min(Comparator.comparingDouble(Animal::getWeight)).orElse(null);
    }

    public Tailed getLongestTailAnimal(List<Tailed> tailedAnimals) {
        return tailedAnimals.stream().max(Comparator.comparingDouble(Tailed::getTailLength)).orElse(null);
    }

    public Winged getLargestWingspanAnimal(List<Winged> wingedAnimals) {
        return wingedAnimals.stream().max(Comparator.comparingDouble(Winged::getWingspan)).orElse(null);
    }

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
