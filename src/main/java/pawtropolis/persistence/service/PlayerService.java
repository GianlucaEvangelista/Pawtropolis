package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.game.model.Item;
import pawtropolis.game.model.Player;
import pawtropolis.persistence.marshaller.PlayerMarshaller;
import pawtropolis.persistence.model.BagEntity;
import pawtropolis.persistence.model.PlayerEntity;
import pawtropolis.persistence.repository.PlayerRepository;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMarshaller playerMarshaller;
    private final BagService bagService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PlayerMarshaller playerMarshaller, BagService bagService) {
        this.playerRepository = playerRepository;
        this.playerMarshaller = playerMarshaller;
        this.bagService = bagService;
    }

    public Optional<Player> getPlayerById(int id) {
        Optional<PlayerEntity> optionalPlayerEntity = playerRepository.findById(id);
        return optionalPlayerEntity.map(playerMarshaller::toPlayer);
    }

    public void savePlayer(Player player) {
        BagEntity bagEntity = bagService.saveBag(player.getBag());
        player.getBag().setId(bagEntity.getId());
        PlayerEntity playerEntity = playerMarshaller.toPlayerEntity(player, bagEntity);
        playerRepository.save(playerEntity);
    }

    public void addItemEntityToBagEntity(Item item, Player player) {
        BagEntity bagEntity = bagService.getBagEntityById(player.getBag().getId());
        bagService.addItemEntity(item, bagEntity);
    }

    public void removeItemEntityFromBagEntity(Item item, Player player) {
        BagEntity bagEntity = bagService.getBagEntityById(player.getBag().getId());
        bagService.removeItemEntity(bagEntity, item);
    }
}
