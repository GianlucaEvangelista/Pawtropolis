package zoo;
import java.time.LocalDate;

public class Winged extends Animal {
    private double wingspan;

    public Winged(String species, String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double wigspan) {
        super(species, name, favouriteFood, age, arrivalDate, weight, height);
        setWingspan(wigspan);
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }
}
