package pawtropolis.persistence.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.game.model.Item;
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
    private final ItemService itemService;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomLinkService roomLinkService, RoomMarshaller roomMarshaller, ItemRepository itemRepository, ItemService itemService) {
        this.roomRepository = roomRepository;
        this.roomLinkService = roomLinkService;
        this.roomMarshaller = roomMarshaller;
        this.itemRepository = itemRepository;
        this.itemService = itemService;
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
        room.setAdjacentRooms(roomLinkService.getRoomLinkByRoomId(roomEntity.getId()));
        return room;
    }

    @Transactional
    public void removeItemEntityFromRoomEntity(Room room, Item item) {
        roomRepository.deleteItemFromRoom(room.getId(), item.getId());
    }

    public void addItem(Room room, Item item) {
        ItemEntity itemEntity = itemService.getItemEntityById(item.getId());
        RoomEntity roomEntity = getRoomEntityById(room.getId());
        roomEntity.getItemEntities().add(itemEntity);
        roomRepository.save(roomEntity);
    }

    public boolean containsItem(Room room, String itemName) {
        RoomEntity roomEntity = getRoomEntityById(room.getId());
        return roomEntity.getItemEntities().stream().anyMatch(item -> item.getName().equals(itemName));
    }

    public Room getEntrance(Integer mapId) {
        Integer entranceId = roomRepository.getEntranceIdFromMapId(mapId, "Entrance");
        Room room = roomMarshaller.toRoom(getRoomEntityById(entranceId));
        room.setAdjacentRooms(roomLinkService.getRoomLinkByRoomId(room.getId()));
        return room;
    }
}
