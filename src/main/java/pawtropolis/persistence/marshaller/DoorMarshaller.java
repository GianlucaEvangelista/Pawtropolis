package pawtropolis.persistence.marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.model.Item;
import pawtropolis.map.model.Door;
import pawtropolis.persistence.model.DoorEntity;

@Component
public class DoorMarshaller {

    private final ItemMarshaller itemMarshaller;

    @Autowired
    public DoorMarshaller(ItemMarshaller itemMarshaller) {
        this.itemMarshaller = itemMarshaller;
    }

    public DoorEntity toDoorEntity(Door door) {
        DoorEntity doorEntity = new DoorEntity();
        doorEntity.setLocked(door.isLocked());
        doorEntity.setKeyItemEntity(itemMarshaller.toItemEntity(door.getKeyItem()));
        return doorEntity;
    }

    public Door toDoor(DoorEntity doorEntity) {
        boolean locked = doorEntity.getLocked();
        Item keyItem = itemMarshaller.toItem(doorEntity.getKeyItemEntity());
        return new Door(locked, keyItem);
    }
}
