package pawtropolis.game.model;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.persistence.model.BagEntity;
import pawtropolis.persistence.service.BagService;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class Bag {

    private final List<Item> items;
    private int availableSlots;
    private static final int MAX_SLOTS = 10;
    private BagService bagService;

    @Autowired
    private Bag(BagService bagService) {
        this.availableSlots = MAX_SLOTS;
        this.items = new ArrayList<>();
        this.bagService = bagService;
    }

    public Bag(List<Item> items, int availableSlots) {
        this.items = items;
        this.availableSlots = availableSlots;
    }

    public BagEntity saveBag() {
        return bagService.saveBag(this);
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

    public boolean isThereEnoughSpace(Item itemToAdd) {
        return getAvailableSlots() >= itemToAdd.getRequiredSlots();
    }
}
