package pawtropolis.game.model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Item {

    private String name;
    private String description;
    private int requiredSlots;

}
