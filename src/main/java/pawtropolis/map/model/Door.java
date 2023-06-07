package pawtropolis.map.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pawtropolis.game.model.Item;

@Getter
@Setter
@AllArgsConstructor
public class Door {

    private boolean locked;

    private Item keyItem;

    public boolean unlockDoor(Item item) {
        if(this.keyItem == item) {
            this.locked = false;
            return true;
        }
        System.out.println("This isn't the right item to open this door!");
        return false;
    }
}
