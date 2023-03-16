package pawtropolis.player;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private String name;
    private int lifePoints;
    private static final int MAX_LIFE_POINTS = 100;
    private final Bag bag;

    public Player(String name) {
        this.name = name;
        this.lifePoints = MAX_LIFE_POINTS;
        this.bag = new Bag();
    }

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag();
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItemToBag(Item item) {
        bag.addItem(item);
    }

    public void removeItemFromBag(Item item) {
        bag.removeItem(item);
    }

    public void removeItemFromBag(String itemName) {
        bag.removeItem(itemName);
    }

    public List<String> getItemsInBag() {
        return bag.getItems().stream().map(Item::getName).collect(Collectors.toList());
    }

    public Item getItemFromBag(String itemName) {
        return bag.getItem(itemName);
    }

    public boolean isThereEnoughSpace(Item itemToAdd) {
        return bag.getAvailableSlots() >= itemToAdd.getRequiredSlots();
    }

    public boolean isItemInBag(String itemName) {
        return bag.getItems().stream().anyMatch(item -> item.getName().equals(itemName));
    }
}
