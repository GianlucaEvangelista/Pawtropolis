package pawtropolis.zoo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Species {
    TIGER("Tiger", Tiger.class),
    LION("Lion", Lion.class),
    EAGLE("Eagle", Eagle.class);
    private final String speciesString;
    private final Class<? extends Animal> speciesClass;
    public static Species fromString(String speciesString) {
        return Arrays.stream(Species.values())
                .filter(species -> species.getSpeciesString().equals(speciesString))
                .findFirst().orElse(null);
    }
    public static Species fromSpeciesClass(Class<? extends Animal> speciesClass) {
        return Arrays.stream(Species.values())
                .filter(species -> species.getSpeciesClass().equals(speciesClass))
                .findFirst().orElse(null);
    }
}
