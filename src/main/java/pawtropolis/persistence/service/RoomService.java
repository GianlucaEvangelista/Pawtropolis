package pawtropolis.persistence.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.marshaller.RoomMarshaller;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.model.RoomEntity;
import pawtropolis.persistence.repository.ItemRepository;
import pawtropolis.persistence.repository.RoomRepository;
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

    public ItemEntity getItemEntityFromRoom(Room room, String itemName) {
        Integer itemId = roomRepository.getItemIdFromRoom(room.getName(), itemName);
        Optional<ItemEntity> optionalItemEntity = itemRepository.findById(itemId);
        return optionalItemEntity.orElse(null);
    }

    public Room getRoomByName(String name) {
        RoomEntity roomEntity = roomRepository.findByName(name);
        Room room = roomMarshaller.toRoom(roomEntity);
        room.setAdjacentRooms(roomLinkService.getRoomLinkByRoomEntityId(roomEntity.getId()));
        return room;
    }

    @Transactional
    public void removeItemFromRoom(Room room, ItemEntity itemEntity) {
        roomRepository.deleteItemInRoom(room.getName(), itemEntity.getId());
    }
}
