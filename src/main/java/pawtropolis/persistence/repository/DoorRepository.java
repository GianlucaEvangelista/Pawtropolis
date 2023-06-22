package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pawtropolis.persistence.model.DoorEntity;

@Repository
public interface DoorRepository extends JpaRepository<DoorEntity, Integer> {
}
