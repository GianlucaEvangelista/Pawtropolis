package pawtropolis.persistence.repository;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pawtropolis.persistence.model.SpeciesEntity;

@Repository
public interface SpeciesRepository extends JpaRepository<SpeciesEntity, Integer> {
    SpeciesEntity findByName(@NonNull String name);
}
