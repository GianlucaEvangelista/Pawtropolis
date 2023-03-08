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
}
