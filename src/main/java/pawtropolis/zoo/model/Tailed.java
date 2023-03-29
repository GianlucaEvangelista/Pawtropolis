package pawtropolis.zoo.model;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public abstract class Tailed extends Animal {
    private double tailLength;

    protected Tailed(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, arrivalDate, weight, height);
        this.tailLength = tailLength;
    }

}
