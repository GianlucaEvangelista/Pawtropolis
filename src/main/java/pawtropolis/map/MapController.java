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

    private final RoomService roomService;

    @Autowired
    private MapController(RoomService roomService) {
        this.roomService = roomService;
        this.currentRoom = roomService.getRoomByName("Entrance");
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


