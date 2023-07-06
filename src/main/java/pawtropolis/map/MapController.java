package pawtropolis.map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.model.Item;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Door;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.service.*;
import pawtropolis.utils.Pair;
import java.util.Map;

@Getter
@Setter
@Component
public class MapController {

    @Getter(AccessLevel.NONE)
    private Room currentRoom;

    private final RoomService roomService;
    private final DoorService doorService;

    @Autowired
    private MapController(RoomService roomService, DoorService doorService) {
        this.roomService = roomService;
        this.doorService = doorService;
        this.currentRoom = roomService.getRoomByName("Entrance");
    }

    public boolean currentRoomContainsItem(String itemName) {
        return roomService.containsItem(currentRoom, itemName);
    }

    public ItemEntity getCurrentRoomItemEntity(String itemName) {
        return roomService.getItemEntityFromRoom(currentRoom, itemName);
    }

    public Item getCurrentRoomItem (String itemName) {
        return currentRoom.getItem(itemName);
    }

    public void addItemToCurrentRoom (Item item) {
        currentRoom.addItem(item);
    }

    public void addItemEntityToRoomEntity (Item item) {
        roomService.addItem(currentRoom, item);
    }

    public void removeItemEntityFromCurrentRoom(Item item) {
        roomService.removeItemEntityFromRoomEntity(currentRoom, item);
    }

    public void removeItemFromCurrentRoom(Item item) {
        currentRoom.removeItem(item);
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public Map<Direction, Pair<Room, Door>> getCurrentRoomAdjacentRooms() {
        return currentRoom.getAdjacentRooms();
    }

    public void changeRoom(Direction direction) {
        Room nextRoom = currentRoom.getAdjacentRoom(direction);
        if (nextRoom != null) {
            currentRoom = roomService.getRoomById(nextRoom.getId());
        }
    }

    public void unlockDoorEntity(Door door) {
        this.doorService.unlockDoorEntity(door);
    }
}


