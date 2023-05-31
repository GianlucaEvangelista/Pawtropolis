package pawtropolis.map.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pawtropolis.player.Item;

@Getter
@Setter
@AllArgsConstructor
public class Door {

    private boolean isOpen;

    private Item keyItem;

    public boolean openTheDoor(Item item) {
        if(this.keyItem == item) {
            this.isOpen = true;
            return true;
        }
        System.out.println("This isn't the right item to open this door!");
        return false;
    }
}
