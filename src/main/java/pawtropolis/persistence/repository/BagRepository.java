package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.persistence.model.BagEntity;

public interface BagRepository extends JpaRepository<BagEntity, Integer> {
}
