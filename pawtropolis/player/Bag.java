package pawtropolis.player;
import java.util.ArrayList;
import java.util.List;

public class Bag {

    private final List<Item> items;

    private static final int MAX_SLOTS = 10;

    public Bag() {
        this.items = new ArrayList<>(MAX_SLOTS);
    }

    public List<Item> getItems() {
        return items;
    }

}
