package zoo;
import java.time.LocalDate;

public class Tailed extends Animal {
    private double tailLength;

    public Tailed(String species, String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double tailLength) {
        super(species, name, favouriteFood, age, arrivalDate, weight, height);
        setTailLength(tailLength);
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }
}
