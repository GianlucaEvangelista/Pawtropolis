package zoo;
import java.time.LocalDate;
import java.util.ArrayList;

public class Zoo {
    public static void main(String[] args) {

        Operations operations = new Operations();

        // liste di animali
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Animal> tigers = new ArrayList<>();
        ArrayList<Animal> lions = new ArrayList<>();
        ArrayList<Animal> eagles = new ArrayList<>();
        ArrayList<Tailed> taileds = new ArrayList<>();
        ArrayList<Winged> wingeds = new ArrayList<>();

        // dati animali hard-codati aggiunti all'ArrayList animali
        animals.add(new Tailed("tigre","Black", "Carne di mucca", 7, LocalDate.of(2022,4,5), 220.30, 92.70, 82.10));
        animals.add(new Tailed("tigre","Zelda", "Carne di maiale", 8, LocalDate.of(2021,9,10), 242.80, 87.90, 81.80));
        animals.add(new Tailed("tigre","Arya", "Carne di maiale", 10, LocalDate.of(2020,7,11), 260.00, 94.00, 86.50));
        animals.add(new Tailed("leone","Leo", "Carne di vitello", 7, LocalDate.of(2019,6,27), 190.00, 118.50, 91.20));
        animals.add(new Tailed("leone","Asia", "Carne di maiale", 5, LocalDate.of(2020,12,7), 172.00, 109.20, 84.30));
        animals.add(new Tailed("leone","Simba", "Carne di maiale", 6, LocalDate.of(2021,3,10), 184.60, 112.50, 87.40));
        animals.add(new Tailed("leone","Argo", "Carne di vitello", 9, LocalDate.of(2020,6,23), 192.10, 116.80, 92.10));
        animals.add(new Winged("aquila","Sky", "Carne di pernice", 3, LocalDate.of(2021,4,20), 4.50, 81.20, 210.10));
        animals.add(new Winged("aquila","White", "Carne di quaglia", 4, LocalDate.of(2019,2,5), 4.30, 80.50, 212.30));
        animals.add(new Winged("aquila","Jack", "Carne di pernice", 2, LocalDate.of(2022,7,20), 3.90, 77.20, 182.70));


        // inizializzazione liste specifiche
        for(Animal animal : animals) {
            if(animal.getSpecies().equals("tigre")) {
                tigers.add(animal);
                taileds.add((Tailed) animal);
            } else if(animal.getSpecies().equals("leone")) {
                lions.add(animal);
                taileds.add((Tailed) animal);
            } else {
                eagles.add(animal);
                wingeds.add((Winged) animal);
            }
        }


        // inizio interazione utente
        System.out.println("Benvenuto nel sistema di gestione dello zoo");
        System.out.println();
        boolean again = true;
        do {
            // gestione richiesta utente
            switch(operations.searchMenu()) {
                // richiesta animale più alto
                case 1:
                    switch(operations.speciesSelection()) {
                        case 1:
                            System.out.println("La tigre più alta è " + operations.tallest(tigers).getName() + " (" + operations.tallest(tigers).getHeight() + " cm)");
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Il leone più alto è " + operations.tallest(lions).getName() + " (" + operations.tallest(lions).getHeight() + " cm)");
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("L'aquila più alta è " + operations.tallest(eagles).getName() + " (" + operations.tallest(eagles).getHeight() + " cm)");
                            System.out.println();
                            break;
                        case 4:
                            continue;
                        default:
                            System.out.println("Valore inserito non valido!");
                            System.out.println();
                    }
                    break;
                // richiesta animale più basso
                case 2:
                    switch(operations.speciesSelection()) {
                        case 1:
                            System.out.println("La tigre più bassa è " + operations.shortest(tigers).getName() + " (" + operations.shortest(tigers).getHeight() + " cm)");
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Il leone più basso è " + operations.shortest(lions).getName() + " (" + operations.shortest(lions).getHeight() + " cm)");
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("L'aquila più bassa è " + operations.shortest(eagles).getName() + " (" + operations.shortest(eagles).getHeight() + " cm)");
                            System.out.println();
                            break;
                        case 4:
                            continue;
                        default:
                            System.out.println("Valore inserito non valido!");
                            System.out.println();
                    }
                    break;
                // richiesta animale più pesante
                case 3:
                    switch(operations.speciesSelection()) {
                        case 1:
                            System.out.println("La tigre più pesante è " + operations.heaviest(tigers).getName() + " (" + operations.heaviest(tigers).getWeight() + " kg)");
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Il leone più pesante è " + operations.heaviest(lions).getName() + " (" + operations.heaviest(lions).getWeight() + " kg)");
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("L'aquila più pesante è " + operations.heaviest(eagles).getName() + " (" + operations.heaviest(eagles).getWeight() + " kg)");
                            System.out.println();
                            break;
                        case 4:
                            continue;
                        default:
                            System.out.println("Valore inserito non valido!");
                            System.out.println();
                    }
                    break;
                // richiesta animale più leggero
                case 4:
                    switch(operations.speciesSelection()) {
                        case 1:
                            System.out.println("La tigre più leggera è " + operations.lightest(tigers).getName() + " (" + operations.lightest(tigers).getWeight() + " kg)");
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Il leone più leggero è " + operations.lightest(lions).getName() + " (" + operations.lightest(lions).getWeight() + " kg)");
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("L'aquila più leggera è " + operations.lightest(eagles).getName() + " (" + operations.lightest(eagles).getWeight() + " kg)");
                            System.out.println();
                            break;
                        case 4:
                            continue;
                        default:
                            System.out.println("Valore inserito non valido!");
                            System.out.println();
                    }
                    break;
                // richiesta animale con coda più lunga
                case 5:
                    Tailed tail = operations.longestTail(taileds);
                    System.out.println("L'esemplare con la coda più lunga è " + tail.getName() + ", " + tail.getSpecies() + " con la coda di " + tail.getTailLength() + " cm.");
                    System.out.println();
                    break;
                // richiesta animale con maggiore apertura alare
                case 6:
                    Winged wings = operations.largestWingspan(wingeds);
                    System.out.println("L'esemplare con l'apertura alare maggiore è " + wings.getName() + ", " + wings.getSpecies() + " con l'apertura alare di " + wings.getWingspan() + " cm.");
                    System.out.println();
                    break;
                // richiesta chiusura programma
                case 7:
                    again = false;
                    break;
                // richiesta non valida
                default:
                    System.out.println("Valore inserito non valido!");
                    System.out.println();
            }
        } while(again);

        // chiusura programma
        System.out.println("Ricerca terminata!");
        System.exit(0);

    }
}
