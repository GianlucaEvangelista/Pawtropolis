package pawtropolis.zoo.model;

import pawtropolis.zoo.model.Tailed;

import java.time.LocalDate;

public class Tiger extends Tailed {

    public Tiger (String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, arrivalDate, weight, height, tailLength);
    }
}
