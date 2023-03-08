package pawtropolis.zoo;
import java.time.LocalDate;

public class Winged extends Animal {
    private double wingspan;

    public Winged(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double wigspan) {
        super(name, favouriteFood, age, arrivalDate, weight, height);
        this.wingspan = wigspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }
}
