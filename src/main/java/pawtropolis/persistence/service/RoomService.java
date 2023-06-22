package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.marshaller.RoomLinkMarshaller;
import pawtropolis.persistence.marshaller.RoomMarshaller;
import pawtropolis.persistence.model.RoomEntity;
import pawtropolis.persistence.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomLinkService roomLinkService;
    private final RoomMarshaller roomMarshaller;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomLinkService roomLinkService, RoomMarshaller roomMarshaller) {
        this.roomRepository = roomRepository;
        this.roomLinkService = roomLinkService;
        this.roomMarshaller = roomMarshaller;
    }

    public Room getRoomById(int id) {
        RoomEntity roomEntity = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        Room room = roomMarshaller.toRoom(roomEntity);
        room.setAdjacentRooms(roomLinkService.getRoomLinkByRoomEntityId(id));
        return room;
    }
}
