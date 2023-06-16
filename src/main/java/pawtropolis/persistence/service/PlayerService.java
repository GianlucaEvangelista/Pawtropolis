package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.game.model.Player;
import pawtropolis.persistence.marshaller.PlayerMarshaller;
import pawtropolis.persistence.model.BagEntity;
import pawtropolis.persistence.model.PlayerEntity;
import pawtropolis.persistence.repository.PlayerRepository;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    private final PlayerMarshaller playerMarshaller;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PlayerMarshaller playerMarshaller) {
        this.playerRepository = playerRepository;
        this.playerMarshaller = playerMarshaller;
    }

    public Player getPlayerById(int id) {
        PlayerEntity playerEntity = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        return playerMarshaller.toPlayer(playerEntity);
    }

    public void savePlayer(Player player, BagEntity bagEntity) {
        PlayerEntity playerEntity = playerMarshaller.toPlayerEntity(player, bagEntity);
        playerRepository.save(playerEntity);
    }
}
