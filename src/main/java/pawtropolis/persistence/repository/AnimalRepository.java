package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.persistence.model.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {
}
