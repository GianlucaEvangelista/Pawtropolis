package pawtropolis.persistence.marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.persistence.model.AnimalEntity;
import pawtropolis.persistence.model.SpeciesEntity;
import pawtropolis.persistence.repository.SpeciesRepository;
import pawtropolis.zoo.model.Animal;
import pawtropolis.zoo.model.Species;
import pawtropolis.zoo.model.Tailed;
import pawtropolis.zoo.model.Winged;
import java.lang.reflect.Constructor;
import java.time.LocalDate;

@Component
public class AnimalMarshaller {
    SpeciesRepository speciesRepository;

    @Autowired
    public AnimalMarshaller(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public <T extends Animal> AnimalEntity toAnimalEntity(T animal) {
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setName(animal.getName());
        animalEntity.setFavouriteFood(animal.getFavouriteFood());
        animalEntity.setAge(animal.getAge());
        animalEntity.setArrivalDate(animal.getArrivalDate());
        animalEntity.setWeight(animal.getWeight());
        animalEntity.setHeight(animal.getHeight());
        if (Tailed.class.isAssignableFrom(animal.getClass())) {
            animalEntity.setTailLength(((Tailed) animal).getTailLength());
        } else if (Winged.class.isAssignableFrom(animal.getClass())) {
            animalEntity.setWingspan(((Winged) animal).getWingspan());
        }
        String species = Species.fromSpeciesClass(animal.getClass()).getSpeciesString();
        SpeciesEntity speciesEntity = speciesRepository.findByName(species);
        animalEntity.setSpeciesEntity(speciesEntity);
        return animalEntity;
    }

    public <T extends Animal> T toAnimal(AnimalEntity animalEntity) {
        String animalName = animalEntity.getName();
        String animalFavouriteFood = animalEntity.getFavouriteFood();
        int animalAge = animalEntity.getAge();
        LocalDate animalArrivalDate = animalEntity.getArrivalDate();
        Double animalWeight = animalEntity.getWeight();
        Double animalHeight = animalEntity.getHeight();
        Double animalTailLength = animalEntity.getTailLength();
        Double animalWingspan = animalEntity.getWingspan();
        String species = animalEntity.getSpeciesEntity().getName();
        Species speciesClass = Species.fromString(species);
        Class<? extends Animal> animalClass = speciesClass.getSpeciesClass();
        if (animalClass != null) {
            return createAnimalInstance(animalClass, animalName, animalFavouriteFood, animalAge, animalArrivalDate, animalWeight, animalHeight, animalTailLength, animalWingspan);
        }
        return null;
    }
    private <T extends Animal> T createAnimalInstance(Class<? extends Animal> animalClass, String animalName, String animalFavouriteFood, int animalAge, LocalDate animalArrivalDate, Double animalWeight, Double animalHeight, Double animalTailLength, Double animalWingspan) {
        try {
            Constructor<T> constructor = (Constructor<T>) animalClass.getDeclaredConstructor(String.class, String.class, int.class, LocalDate.class, double.class, double.class, double.class);
            if (Tailed.class.isAssignableFrom(animalClass)) {
                return constructor.newInstance(animalName, animalFavouriteFood, animalAge, animalArrivalDate, animalWeight, animalHeight, animalTailLength);
            } else if (Winged.class.isAssignableFrom(animalClass)) {
                return constructor.newInstance(animalName, animalFavouriteFood, animalAge, animalArrivalDate, animalWeight, animalHeight, animalWingspan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
