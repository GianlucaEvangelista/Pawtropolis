package pawtropolis.zoo;
import lombok.Getter;
import pawtropolis.zoo.model.*;

import java.util.*;

@Getter
public class ZooController {


    private final List<Tiger> tigers;
    private final List<Lion> lions;
    private final List<Eagle> eagles;
    private final List<Tailed> tailedAnimals;
    private final List<Winged> wingedAnimals;

    public ZooController() {
        this.tigers = new ArrayList<>();
        this.lions = new ArrayList<>();
        this.eagles = new ArrayList<>();
        this.tailedAnimals = new ArrayList<>();
        this.wingedAnimals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        if(animal instanceof Tiger) {
            tigers.add((Tiger) animal);
            tailedAnimals.add((Tailed) animal);
        } else if(animal instanceof Lion) {
            lions.add((Lion) animal);
            tailedAnimals.add((Tailed) animal);
        } else if(animal instanceof Eagle){
            eagles.add((Eagle) animal);
            wingedAnimals.add((Winged) animal);
        }
    }

    public <T extends Animal> T getTallestAnimal(List<T> animals) {
        return animals.stream().max(Comparator.comparingDouble(Animal::getHeight)).orElse(null);
    }

    public <T extends Animal> T  getShortestAnimal(List<T> animals) {
        return animals.stream().min(Comparator.comparingDouble(Animal::getHeight)).orElse(null);
    }

    public <T extends Animal> T getHeaviestAnimal(List<T> animals) {
        return animals.stream().max(Comparator.comparingDouble(Animal::getWeight)).orElse(null);
    }

    public <T extends Animal> T getLightestAnimal(List<T> animals) {
        return animals.stream().min(Comparator.comparingDouble(Animal::getWeight)).orElse(null);
    }

    public Tailed getLongestTailAnimal(List<Tailed> tailedAnimals) {
        return tailedAnimals.stream().max(Comparator.comparingDouble(Tailed::getTailLength)).orElse(null);
    }

    public Winged getLargestWingspanAnimal(List<Winged> wingedAnimals) {
        return wingedAnimals.stream().max(Comparator.comparingDouble(Winged::getWingspan)).orElse(null);
    }

}
