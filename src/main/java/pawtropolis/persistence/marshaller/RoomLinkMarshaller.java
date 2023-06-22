package pawtropolis.persistence.marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Door;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.model.RoomLinkEntity;
import pawtropolis.utils.Pair;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class RoomLinkMarshaller {
    private final DoorMarshaller doorMarshaller;
    private final RoomMarshaller roomMarshaller;
    private final DirectionMarshaller directionMarshaller;


    @Autowired
    public RoomLinkMarshaller(DoorMarshaller doorMarshaller, RoomMarshaller roomMarshaller, DirectionMarshaller directionMarshaller) {
        this.doorMarshaller = doorMarshaller;
        this.roomMarshaller = roomMarshaller;
        this.directionMarshaller = directionMarshaller;
    }
    public List<RoomLinkEntity> toRoomLinkEntityList(Room room) {
        List<RoomLinkEntity> roomLinkEntityList = new ArrayList<>();
        List<Map.Entry<Direction, Pair<Room, Door>>> mapEntryList = room.getAdjacentRooms().entrySet().stream().toList();
        for (Map.Entry<Direction, Pair<Room, Door>> mapEntry: mapEntryList) {
            RoomLinkEntity roomLinkEntity = new RoomLinkEntity();
            roomLinkEntity.setRoom(roomMarshaller.toRoomEntity(room));
            roomLinkEntity.setAdjacentRoom(roomMarshaller.toRoomEntity(mapEntry.getValue().getFirst()));
            roomLinkEntity.setDoor(doorMarshaller.toDoorEntity(mapEntry.getValue().getSecond()));
            roomLinkEntity.setDirection(directionMarshaller.toDirectionEntity(mapEntry.getKey()));
            roomLinkEntityList.add(roomLinkEntity);
        }
        return roomLinkEntityList;
    }
    public Map<Direction, Pair<Room, Door>> toMap(List<RoomLinkEntity> roomLinks) {
        Map<Direction, Pair<Room, Door>> adjacentRooms = new EnumMap<>(Direction.class);
        for (RoomLinkEntity roomLink: roomLinks) {
            Direction direction = directionMarshaller.toDirection(roomLink.getDirection());
            Door door = doorMarshaller.toDoor(roomLink.getDoor());
            Room adjacentRoom = roomMarshaller.toRoom(roomLink.getAdjacentRoom());
            adjacentRooms.put(direction, new Pair<>(adjacentRoom, door));
        };
        return adjacentRooms;
    }
}
