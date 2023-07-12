package pawtropolis.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pawtropolis.persistence.model.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {

    @Query(value = "SELECT map_id FROM games WHERE player_id = :playerId", nativeQuery = true)
    Integer getMapIdFromPlayerId(@Param("playerId") Integer playerId);
}
