package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.model.RoomLinkEntity;

import java.util.List;

public interface RoomLinkRepository extends JpaRepository<RoomLinkEntity, Integer> {
    List<RoomLinkEntity> findByRoomId(Integer roomId);
}
