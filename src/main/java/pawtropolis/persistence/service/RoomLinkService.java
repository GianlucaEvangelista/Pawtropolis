package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Door;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.marshaller.RoomLinkMarshaller;
import pawtropolis.persistence.repository.RoomLinkRepository;
import pawtropolis.utils.Pair;
import java.util.Map;

@Service
public class RoomLinkService {
    private final RoomLinkRepository roomLinkRepository;
    private final RoomLinkMarshaller roomLinkMarshaller;

    @Autowired
    public RoomLinkService(RoomLinkRepository roomLinkRepository, RoomLinkMarshaller roomLinkMarshaller) {
        this.roomLinkRepository = roomLinkRepository;
        this.roomLinkMarshaller = roomLinkMarshaller;
    }

    public Map<Direction, Pair<Room, Door>> getRoomLinkByRoomId(Integer roomId) {
        return roomLinkMarshaller.toMap(roomLinkRepository.findByRoomId(roomId));
    }
}
