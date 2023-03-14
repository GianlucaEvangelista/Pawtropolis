package pawtropolis.zoo.model;
import pawtropolis.zoo.model.Animal;

import java.time.LocalDate;

public class Tailed extends Animal {
    private double tailLength;

    public Tailed(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, arrivalDate, weight, height);
        this.tailLength = tailLength;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }
}
