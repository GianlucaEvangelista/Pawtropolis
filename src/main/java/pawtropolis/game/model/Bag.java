package pawtropolis.game.model;
import lombok.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class Bag {

    private final List<Item> items;
    private int availableSlots;
    private static final int MAX_SLOTS = 10;

    private Bag() {
        this.availableSlots = MAX_SLOTS;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if(getAvailableSlots() - item.getRequiredSlots() >= 0) {
            items.add(item);
            availableSlots -= item.getRequiredSlots();
        }
    }

    public void removeItem(Item item) {
        items.removeIf(i -> i.getName().equals(item.getName()));
        availableSlots += item.getRequiredSlots();
    }

    public Item getItem(String itemName) {
        return items.stream().filter(i -> i.getName().equals(itemName)).findAny().orElse(null);
    }
}
