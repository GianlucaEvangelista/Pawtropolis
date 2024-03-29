package pawtropolis.zoo.model;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Eagle extends Winged {

    public Eagle(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double wingspan) {
        super(name, favouriteFood, age, arrivalDate, weight, height, wingspan);
    }
}
