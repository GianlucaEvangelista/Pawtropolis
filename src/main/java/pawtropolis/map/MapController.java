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

    @Autowired
    private MapController(RoomService roomService) {
        this.roomService = roomService;
        this.currentRoom = roomService.getRoomByName("Entrance");
    }

    public boolean currentRoomContainsItem(String itemName) {
        return roomService.containsItem(currentRoom, itemName);
    }

    public ItemEntity getCurrentRoomItemEntity(String itemName) {
        return roomService.getItemEntityFromRoom(currentRoom, itemName);
    }

    public void addItemEntityToRoomEntity (Item item) {
        roomService.addItem(currentRoom, item);
    }

    public void removeItemFromCurrentRoom (ItemEntity itemEntity) {
        roomService.removeItemFromRoom(currentRoom, itemEntity);
    }

    public String getCurrentRoomDescription() {
        return roomService.getRoomById(currentRoom.getId()).getDescription();
    }

    public Map<Direction, Pair<Room, Door>> getCurrentRoomAdjacentRooms() {
        return roomService.getAdjacentRooms(currentRoom);
    }

    public void changeRoom(Direction direction) {
        Room nextRoom = currentRoom.getAdjacentRoom(direction);
        if (nextRoom != null) {
            currentRoom = roomService.getRoomById(nextRoom.getId());
        }
    }
}


