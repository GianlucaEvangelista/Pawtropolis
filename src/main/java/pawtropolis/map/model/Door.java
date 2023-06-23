package pawtropolis.map.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pawtropolis.game.model.Item;

@Getter
@Setter
@AllArgsConstructor
public class Door {
    private Integer id;

    private boolean locked;

    private Item keyItem;

    public Door(){
        locked = false;
    }

    public boolean unlockDoor(Item item) {
        if(item != null && isTheRightKey(item)) {
            this.locked = false;
        }
        return !isLocked();
    }

    public boolean isTheRightKey(Item item) {
        return this.keyItem.getName().equals(item.getName()) &&
                this.keyItem.getDescription().equals(item.getDescription()) &&
                this.keyItem.getRequiredSlots() == item.getRequiredSlots();
    }
}
