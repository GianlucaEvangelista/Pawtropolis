package zoo;
import  java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operations {

    // metodo animale più alto
    public Animal tallest(ArrayList<Animal> animals) {
        Animal tallestAnimal = animals.stream().max(Comparator.comparingDouble(Animal::getHeight)).orElse(null);
        return tallestAnimal;
    }

    // metodo animale più basso
    public Animal shortest(ArrayList<Animal> animals) {
        Animal shortestAnimal = animals.stream().min(Comparator.comparingDouble(Animal::getHeight)).orElse(null);
        return shortestAnimal;
    }

    // metodo animale più pesante
    public Animal heaviest(ArrayList<Animal> animals) {
        Animal heaviestAnimal = animals.stream().max(Comparator.comparingDouble(Animal::getWeight)).orElse(null);
        return heaviestAnimal;
    }

    // metodo animale più leggero
    public Animal lightest(ArrayList<Animal> animals) {
        Animal lightestAnimal = animals.stream().min(Comparator.comparingDouble(Animal::getWeight)).orElse(null);
        return lightestAnimal;
    }

    // metodo animale con la coda più lunga
    public Tailed longestTail(ArrayList<Tailed> taileds) {
        Tailed longestTail = taileds.stream().max(Comparator.comparingDouble(Tailed::getTailLength)).orElse(null);
        return longestTail;
    }

    // metodo animale con maggiore apertura alare
    public Winged largestWingspan(ArrayList<Winged> wingeds) {
        Winged largestWingspan = wingeds.stream().max(Comparator.comparingDouble(Winged::getWingspan)).orElse(null);
        return largestWingspan;
    }

    // metodo menu di selezione ricerca
    public int searchMenu() {
        Scanner input = new Scanner(System.in);
        int search = 0;
        boolean again = false;

        do {
            System.out.println("Digitare il numero della ricerca da effettuare");
            System.out.println("1 - Esemplare più alto");
            System.out.println("2 - Esemplare più basso");
            System.out.println("3 - Esemplare più pesante");
            System.out.println("4 - Esemplare più leggero");
            System.out.println("5 - Esemplare con la coda più lunga");
            System.out.println("6 - Esemplare con la maggiore apertura alare");
            System.out.println("7 - Chiudi il programma");
            try {
                search = input.nextInt();
                System.out.println();
                again = false;
            }
            catch (InputMismatchException exception) {
                System.out.println();
                System.out.println("Caratteri inseriti non validi!");
                input.nextLine();
                System.out.println();
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
            System.out.println("Per quale specie vuoi effettuare la ricerca (digitare il numero corrispondente)?");
            System.out.println("1 - Tigri");
            System.out.println("2 - Leoni");
            System.out.println("3 - Aquile");
            System.out.println("4 - Torna indietro");
            try {
                selectedSpecies = input.nextInt();
                System.out.println();
                again = false;
            }
            catch (InputMismatchException exception) {
                System.out.println();
                System.out.println("Caratteri inseriti non validi!");
                input.nextLine();
                System.out.println();
                again = true;
            }
        } while(again);

        return selectedSpecies;
    }
}
