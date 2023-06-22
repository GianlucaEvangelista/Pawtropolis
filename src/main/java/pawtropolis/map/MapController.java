package pawtropolis.map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Door;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.service.*;
import pawtropolis.utils.Pair;
import pawtropolis.game.model.Item;
import pawtropolis.zoo.model.Animal;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component
public class MapController {

    @Getter(AccessLevel.NONE)
    private Room currentRoom;

    private final ItemService itemService;
    private final AnimalService animalService;
    private final RoomService roomService;
    private final DoorService doorService;
    private final DirectionService directionService;

    @Autowired
    private MapController(ItemService itemService, AnimalService animalService, RoomService roomService, DoorService doorService, DirectionService directionService) {
        this.itemService = itemService;
        this.animalService = animalService;
        this.roomService = roomService;
        this.doorService = doorService;
        this.directionService = directionService;
        this.currentRoom = createMap();
    }

    private Room createMap() {
        Room entrance = roomService.getRoomById(1);
        Room bedroom = roomService.getRoomById(2);
        bedroom.addAdjacentRoom(entrance, doorService.getDoorById(1), directionService.getDirectionById(4));
        Room kitchen = roomService.getRoomById(3);
        kitchen.addAdjacentRoom(entrance, doorService.getDoorById(2), directionService.getDirectionById(3));
        Room livingRoom = roomService.getRoomById(4);
        livingRoom.addAdjacentRoom(entrance, doorService.getDoorById(3), directionService.getDirectionById(2));
        Room bathroom = roomService.getRoomById(5);
        bathroom.addAdjacentRoom(livingRoom, doorService.getDoorById(4), directionService.getDirectionById(1));
        return entrance;
    }

    public boolean currentRoomContainsItem(String itemName) {
        return currentRoom.containsItem(itemName);
    }

    public Item getCurrentRoomItem (String itemName) {
        return currentRoom.getItem(itemName);
    }

    public List<Item> getCurrentRoomItems() {
        return currentRoom.getItems();
    }

    public void addItemToCurrentRoom (Item item) {
        currentRoom.addItem(item);
    }

    public void removeItemFromCurrentRoom (Item item) {
        currentRoom.removeItem(item);
    }

    public List<Animal> getCurrentRoomAnimals() {
        return currentRoom.getAnimals();
    }

    public String getCurrentRoomItemsNames() {
        return currentRoom.getItemsNames();
    }

    public String getCurrentRoomAnimalsNames() {
        return currentRoom.getAnimalsNames();
    }

    public String getCurrentRoomAdjacentRoomsDescription() {
        return currentRoom.getAdjacentRoomsDescription();
    }

    public String getCurrentRoomDescription() {
        return  currentRoom.getDescription();
    }

    public Map<Direction, Pair<Room, Door>> getCurrentRoomAdjacentRooms() {
        return currentRoom.getAdjacentRooms();
    }

    public Door getCurrentRoomAdjacentRoomDoor(Direction direction) {
        return currentRoom.getAdjacentRoomDoor(direction);
    }

    public void changeRoom(Direction direction) {
        Room nextRoom = currentRoom.getAdjacentRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
        }
    }
}


