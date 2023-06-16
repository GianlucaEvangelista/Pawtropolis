package pawtropolis.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pawtropolis.persistence.model.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
}
