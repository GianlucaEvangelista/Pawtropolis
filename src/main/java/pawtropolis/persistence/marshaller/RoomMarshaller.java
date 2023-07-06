package pawtropolis.persistence.marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.model.Item;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.model.RoomEntity;
import pawtropolis.zoo.model.Animal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

@Component
public class RoomMarshaller {

    private final AnimalMarshaller animalMarshaller;

    private final ItemMarshaller itemMarshaller;

    @Autowired
    public RoomMarshaller(AnimalMarshaller animalMarshaller, ItemMarshaller itemMarshaller) {
        this.animalMarshaller = animalMarshaller;
        this.itemMarshaller = itemMarshaller;
    }

    public RoomEntity toRoomEntity(Room room) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setName(room.getName());
        roomEntity.setItemEntities(room.getItems().stream().map(itemMarshaller::toItemEntity).toList());
        roomEntity.setAnimalEntities(room.getAnimals().stream().map(animalMarshaller::toAnimalEntity).toList());
        roomEntity.setAdjacentRooms(null);
        return roomEntity;
    }

    public Room toRoom(RoomEntity roomEntity) {
        Integer id = roomEntity.getId();
        String name = roomEntity.getName();
        List<Item> items = new ArrayList<>(roomEntity.getItemEntities().stream().map(itemMarshaller::toItem).toList());
        List<Animal> animals = roomEntity.getAnimalEntities().stream().map(animalMarshaller::toAnimal).toList();
        return new Room(id, name, items, animals, new EnumMap<>(Direction.class));
    }
}
