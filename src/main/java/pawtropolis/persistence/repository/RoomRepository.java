package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pawtropolis.persistence.model.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    @Modifying
    @Query(value = "DELETE FROM items_in_room WHERE room_id = :roomId AND item_id = :itemId", nativeQuery = true)
    void deleteItemFromRoom(@Param("roomId") Integer roomId, @Param("itemId") Integer itemId);

    @Query(value = "SELECT item_id FROM items_in_room WHERE room_id = :roomId AND item_id = (SELECT id FROM items WHERE name = :itemName)", nativeQuery = true)
    Integer getItemIdFromRoom(@Param("roomId") Integer roomId, @Param("itemName") String itemName);

    @Query(value = "SELECT id FROM rooms WHERE map_id = :mapId AND name = :roomName", nativeQuery = true)
    Integer getEntranceIdFromMapId(@Param("mapId") Integer mapId, @Param("roomName") String roomName);
}
