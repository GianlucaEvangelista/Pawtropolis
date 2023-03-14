package pawtropolis.zoo.model;
import java.time.LocalDate;

public abstract class Animal {
    private String name;
    private String favouriteFood;
    private int age;
    private LocalDate arrivalDate;
    private double weight;
    private double height;

    protected Animal(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height) {
        this.name = name;
        this.favouriteFood = favouriteFood;
        this.age = age;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.height = height;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
