package pawtropolis.persistence.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Door;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.marshaller.RoomMarshaller;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.model.RoomEntity;
import pawtropolis.persistence.repository.ItemRepository;
import pawtropolis.persistence.repository.RoomRepository;
import pawtropolis.utils.Pair;
import java.util.Map;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomLinkService roomLinkService;
    private final RoomMarshaller roomMarshaller;
    private final ItemRepository itemRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomLinkService roomLinkService, RoomMarshaller roomMarshaller, ItemRepository itemRepository) {
        this.roomRepository = roomRepository;
        this.roomLinkService = roomLinkService;
        this.roomMarshaller = roomMarshaller;
        this.itemRepository = itemRepository;
    }

    public Room getRoomById(int id) {
        RoomEntity roomEntity = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        Room room = roomMarshaller.toRoom(roomEntity);
        room.setAdjacentRooms(roomLinkService.getRoomLinkByRoomEntityId(id));
        return room;
    }

    public RoomEntity getRoomEntityById(Integer id) {
        Optional<RoomEntity> optionalRoomEntity = roomRepository.findById(id);
        return optionalRoomEntity.orElse(null);
    }

    public ItemEntity getItemEntityFromRoom(Room room, String itemName) {
        Integer itemId = roomRepository.getItemIdFromRoom(room.getId(), itemName);
        Optional<ItemEntity> optionalItemEntity = itemRepository.findById(itemId);
        return optionalItemEntity.orElse(null);
    }

    public Room getRoomByName(String name) {
        RoomEntity roomEntity = roomRepository.findByName(name);
        Room room = roomMarshaller.toRoom(roomEntity);
        room.setAdjacentRooms(roomLinkService.getRoomLinkByRoomEntityId(roomEntity.getId()));
        return room;
    }

    public Room getRoomById(Integer id) {
        RoomEntity roomEntity = getRoomEntityById(id);
        Room room = roomMarshaller.toRoom(roomEntity);
        room.setAdjacentRooms(roomLinkService.getRoomLinkByRoomEntityId(roomEntity.getId()));
        return room;
    }

    @Transactional
    public void removeItemFromRoom(Room room, ItemEntity itemEntity) {
        roomRepository.deleteItemFromRoom(room.getId(), itemEntity.getId());
    }

    public void addItem(Room room, ItemEntity itemEntity) {
        RoomEntity roomEntity = getRoomEntityById(room.getId());
        roomEntity.getItemEntities().add(itemEntity);
        roomRepository.save(roomEntity);
    }

    public Map<Direction, Pair<Room, Door>> getAdjacentRooms(Room room) {
        RoomEntity roomEntity = getRoomEntityById(room.getId());
        return roomLinkService.getRoomLinkByRoomEntityId(roomEntity.getId());
    }

    public boolean containsItem(Room room, String itemName) {
        RoomEntity roomEntity = getRoomEntityById(room.getId());
        return roomEntity.getItemEntities().stream().anyMatch(item -> item.getName().equals(itemName));
    }
}
