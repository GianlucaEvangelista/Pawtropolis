package pawtropolis.game.model;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.console.InputController;
import java.util.List;

@Getter
@Setter
@Component
public class Player {

    private String name;
    private int lifePoints;
    private static final int MAX_LIFE_POINTS = 100;
    @Getter(AccessLevel.NONE)
    private final Bag bag;

    @Autowired
    private Player(Bag bag) {
        this.lifePoints = MAX_LIFE_POINTS;
        this.bag = bag;
        askPlayerName();
    }

    public void askPlayerName() {
        System.out.println("Insert Player's name:");
        setName(InputController.getInputString());
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
        return bag.getItems().stream().map(Item::getName).toList();
    }

    public Item getItemInBag(String itemName) {
        return bag.getItem(itemName);
    }

    public boolean isThereEnoughSpace(Item itemToAdd) {
        return bag.getAvailableSlots() >= itemToAdd.getRequiredSlots();
    }

    public boolean isItemInBag(String itemName) {
        return bag.getItems().stream().anyMatch(item -> item.getName().equals(itemName));
    }
}
