package pawtropolis.player;
import java.util.ArrayList;
import java.util.List;

public class Bag {

    private final List<Item> items;
    private int availableSlots;
    private static final int MAX_SLOTS = 10;

    public Bag() {
        this.availableSlots = MAX_SLOTS;
        this.items = new ArrayList<>(MAX_SLOTS);
    }

    public List<Item> getItems() {
        return items;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
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

    public void removeItem(String itemName) {
        items.stream().filter(i -> i.getName().equals(itemName)).findFirst()
                .ifPresent(i -> {
                    items.remove(i);
                    availableSlots += i.getRequiredSlots();
                });
    }

    public Item getItem(String itemName) {
        return items.stream().filter(i -> i.getName().equals(itemName)).findAny().orElse(null);
    }
}
