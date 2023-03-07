package zoo;
import java.util.*;

public class ZooController {


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

}
