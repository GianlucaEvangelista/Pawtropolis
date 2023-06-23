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
    private final Bag bag;

    @Autowired
    private Player(Bag bag) {
        this.lifePoints = MAX_LIFE_POINTS;
        this.bag = bag;
        askPlayerName();
    }

    public Player(String name, int lifePoints, Bag bag) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = bag;
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

    public List<String> getItemsInBag() {
        return bag.getItems().stream().map(Item::getName).toList();
    }

    public Item getItemInBag(String itemName) {
        return bag.getItem(itemName);
    }

    public boolean hasEnoughSpaceInBag(Item itemToAdd) {
        return bag.isThereEnoughSpace(itemToAdd);
    }

    public boolean isItemInBag(String itemName) {
        return bag.getItems().stream().anyMatch(item -> item.getName().equals(itemName));
    }
}
