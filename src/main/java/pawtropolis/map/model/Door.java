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

}
