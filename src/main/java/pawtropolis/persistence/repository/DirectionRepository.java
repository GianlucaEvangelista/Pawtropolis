package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pawtropolis.persistence.model.DirectionEntity;

@Repository
public interface DirectionRepository extends JpaRepository<DirectionEntity, Integer> {
}
