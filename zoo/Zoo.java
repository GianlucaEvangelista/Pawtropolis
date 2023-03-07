package zoo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Zoo {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Zoo.class.getName());
        ZooController zooController = new ZooController();
        String optionNotValid = "Valore inserito non valido!";

        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Animal> tigers = new ArrayList<>();
        ArrayList<Animal> lions = new ArrayList<>();
        ArrayList<Animal> eagles = new ArrayList<>();
        ArrayList<Tailed> tailedAnimals = new ArrayList<>();
        ArrayList<Winged> wingedAnimals = new ArrayList<>();

        animals.add(new Tailed("tigre","Black", "Carne di mucca", 7, LocalDate.of(2022,4,5), 220.30, 92.70, 82.10));
        animals.add(new Tailed("tigre","Zelda", "Carne di pecora", 8, LocalDate.of(2021,9,10), 242.80, 87.90, 81.80));
        animals.add(new Tailed("tigre","Arya", "Carne di maiale", 10, LocalDate.of(2020,7,11), 260.00, 94.00, 86.50));
        animals.add(new Tailed("leone","Leo", "Carne di vitello", 7, LocalDate.of(2019,6,27), 190.00, 118.50, 91.20));
        animals.add(new Tailed("leone","Asia", "Carne di mucca", 5, LocalDate.of(2020,12,7), 172.00, 109.20, 84.30));
        animals.add(new Tailed("leone","Simba", "Carne di maiale", 6, LocalDate.of(2021,3,10), 184.60, 112.50, 87.40));
        animals.add(new Tailed("leone","Argo", "Carne di vitello", 9, LocalDate.of(2020,6,23), 192.10, 116.80, 92.10));
        animals.add(new Winged("aquila","Sky", "Carne di pernice", 3, LocalDate.of(2021,4,20), 4.50, 81.20, 210.10));
        animals.add(new Winged("aquila","White", "Carne di quaglia", 4, LocalDate.of(2019,2,5), 4.30, 80.50, 212.30));
        animals.add(new Winged("aquila","Jack", "Carne di pernice", 2, LocalDate.of(2022,7,20), 3.90, 77.20, 182.70));


        for(Animal animal : animals) {
            if(animal.getSpecies().equals("tigre")) {
                tigers.add(animal);
                tailedAnimals.add((Tailed) animal);
            } else if(animal.getSpecies().equals("leone")) {
                lions.add(animal);
                tailedAnimals.add((Tailed) animal);
            } else {
                eagles.add(animal);
                wingedAnimals.add((Winged) animal);
            }
        }


        logger.info("Benvenuto nel sistema di gestione dello zoo");
        boolean closeProgram = false;
        do {
            switch(zooController.displayMenuOptions()) {
                case 1:
                    switch(zooController.displaySpeciesOptions()) {
                        case 1:
                            logger.info("La tigre più alta è " + zooController.getTallestAnimal(tigers).getName() + " (" + zooController.getTallestAnimal(tigers).getHeight() + " cm)");
                            break;
                        case 2:
                            logger.info("Il leone più alto è " + zooController.getTallestAnimal(lions).getName() + " (" + zooController.getTallestAnimal(lions).getHeight() + " cm)");
                            break;
                        case 3:
                            logger.info("L'aquila più alta è " + zooController.getTallestAnimal(eagles).getName() + " (" + zooController.getTallestAnimal(eagles).getHeight() + " cm)");
                            break;
                        case 4:
                            continue;
                        default:
                            logger.info(optionNotValid);
                    }
                    break;
                case 2:
                    switch(zooController.displaySpeciesOptions()) {
                        case 1:
                            logger.info("La tigre più bassa è " + zooController.getShortestAnimal(tigers).getName() + " (" + zooController.getShortestAnimal(tigers).getHeight() + " cm)");
                            break;
                        case 2:
                            logger.info("Il leone più basso è " + zooController.getShortestAnimal(lions).getName() + " (" + zooController.getShortestAnimal(lions).getHeight() + " cm)");
                            break;
                        case 3:
                            logger.info("L'aquila più bassa è " + zooController.getShortestAnimal(eagles).getName() + " (" + zooController.getShortestAnimal(eagles).getHeight() + " cm)");
                            break;
                        case 4:
                            continue;
                        default:
                            logger.info(optionNotValid);
                    }
                    break;
                case 3:
                    switch(zooController.displaySpeciesOptions()) {
                        case 1:
                            logger.info("La tigre più pesante è " + zooController.getHeaviestAnimal(tigers).getName() + " (" + zooController.getHeaviestAnimal(tigers).getWeight() + " kg)");
                            break;
                        case 2:
                            logger.info("Il leone più pesante è " + zooController.getHeaviestAnimal(lions).getName() + " (" + zooController.getHeaviestAnimal(lions).getWeight() + " kg)");
                            break;
                        case 3:
                            logger.info("L'aquila più pesante è " + zooController.getHeaviestAnimal(eagles).getName() + " (" + zooController.getHeaviestAnimal(eagles).getWeight() + " kg)");
                            break;
                        case 4:
                            continue;
                        default:
                            logger.info(optionNotValid);
                    }
                    break;
                case 4:
                    switch(zooController.displaySpeciesOptions()) {
                        case 1:
                            logger.info("La tigre più leggera è " + zooController.getLightestAnimal(tigers).getName() + " (" + zooController.getLightestAnimal(tigers).getWeight() + " kg)");
                            break;
                        case 2:
                            logger.info("Il leone più leggero è " + zooController.getLightestAnimal(lions).getName() + " (" + zooController.getLightestAnimal(lions).getWeight() + " kg)");
                            break;
                        case 3:
                            logger.info("L'aquila più leggera è " + zooController.getLightestAnimal(eagles).getName() + " (" + zooController.getLightestAnimal(eagles).getWeight() + " kg)");
                            break;
                        case 4:
                            continue;
                        default:
                            logger.info(optionNotValid);
                    }
                    break;
                case 5:
                    Tailed longestTailAnimal = zooController.getLongestTailAnimal(tailedAnimals);
                    logger.info("L'esemplare con la coda più lunga è " + longestTailAnimal.getName() + ", " + longestTailAnimal.getSpecies() + " con la coda di " + longestTailAnimal.getTailLength() + " cm.");
                    break;
                case 6:
                    Winged largestWingspanAnimal = zooController.getLargestWingspanAnimal(wingedAnimals);
                    logger.info("L'esemplare con l'apertura alare maggiore è " + largestWingspanAnimal.getName() + ", " + largestWingspanAnimal.getSpecies() + " con l'apertura alare di " + largestWingspanAnimal.getWingspan() + " cm.");
                    break;
                case 7:
                    closeProgram = true;
                    break;
                default:
                    logger.info(optionNotValid);
            }
        } while(!closeProgram);

        logger.info("Ricerca terminata!");
        System.exit(0);

    }
}
