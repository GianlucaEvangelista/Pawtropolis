package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.persistence.model.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    RoomEntity findByName(String name);
}
