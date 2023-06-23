package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pawtropolis.persistence.model.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    RoomEntity findByName(String name);
    @Modifying
    @Query(value = "DELETE FROM items_in_room WHERE room_id = (SELECT id FROM rooms WHERE name = :roomName) AND item_id = :itemId", nativeQuery = true)
    void deleteItemInRoom(@Param("roomName") String roomName, @Param("itemId") Integer itemId);
}
