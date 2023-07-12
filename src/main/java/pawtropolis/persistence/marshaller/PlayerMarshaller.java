package pawtropolis.persistence.marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.model.Bag;
import pawtropolis.game.model.Player;
import pawtropolis.persistence.model.BagEntity;
import pawtropolis.persistence.model.PlayerEntity;

@Component
public class PlayerMarshaller {

    private final BagMarshaller bagMarshaller;

    @Autowired
    public PlayerMarshaller(BagMarshaller bagMarshaller) {
        this.bagMarshaller = bagMarshaller;
    }
    public PlayerEntity toPlayerEntity(Player player) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(player.getName());
        playerEntity.setLifePoints(player.getLifePoints());
        playerEntity.setBagEntity(bagMarshaller.toBagEntity(player.getBag()));
        return playerEntity;
    }

    public PlayerEntity toPlayerEntity(Player player, BagEntity bagEntity) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(player.getName());
        playerEntity.setLifePoints(player.getLifePoints());
        playerEntity.setBagEntity(bagEntity);
        return playerEntity;
    }

    public Player toPlayer(PlayerEntity playerEntity) {
        Integer id = playerEntity.getId();
        String playerName = playerEntity.getName();
        int playerLifePoints = playerEntity.getLifePoints();
        Bag playerBag = bagMarshaller.toBag(playerEntity.getBagEntity());
        return new Player(id, playerName, playerLifePoints, playerBag);
    }
}
