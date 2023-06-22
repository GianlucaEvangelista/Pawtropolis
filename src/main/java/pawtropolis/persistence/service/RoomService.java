package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.marshaller.RoomMarshaller;
import pawtropolis.persistence.model.RoomEntity;
import pawtropolis.persistence.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    private final RoomMarshaller roomMarshaller;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomMarshaller roomMarshaller) {
        this.roomRepository = roomRepository;
        this.roomMarshaller = roomMarshaller;
    }

    public Room getRoomById(int id) {
        RoomEntity roomEntity = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        return roomMarshaller.toRoom(roomEntity);
    }
}
