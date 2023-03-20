package pawtropolis.zoo.model;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public abstract class Animal {
    private String name;
    private String favouriteFood;
    private int age;
    private LocalDate arrivalDate;
    private double weight;
    private double height;

}
