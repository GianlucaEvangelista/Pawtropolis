package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.game.model.Item;
import pawtropolis.game.model.Player;
import pawtropolis.persistence.marshaller.PlayerMarshaller;
import pawtropolis.persistence.model.BagEntity;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.model.PlayerEntity;
import pawtropolis.persistence.repository.PlayerRepository;
import java.util.List;

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

    public Player getPlayerById(int id) {
        PlayerEntity playerEntity = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        return playerMarshaller.toPlayer(playerEntity);
    }

    public void savePlayer(Player player) {
        BagEntity bagEntity = bagService.saveBag(player.getBag());
        player.getBag().setId(bagEntity.getId());
        PlayerEntity playerEntity = playerMarshaller.toPlayerEntity(player, bagEntity);
        playerRepository.save(playerEntity);
    }

    public void addItemToBag(ItemEntity itemEntity, Player player) {
        BagEntity bagEntity = bagService.getBagEntityById(player.getBag().getId());
        bagService.addItem(itemEntity, bagEntity);
    }

    public boolean hasEnoughSpaceInBag(ItemEntity itemEntityToAdd, Player player) {
        BagEntity bagEntity = bagService.getBagEntityById(player.getBag().getId());
        return bagService.isThereEnoughSpace(bagEntity, itemEntityToAdd);
    }

    public List<String> getItemsFromBag(Player player) {
        BagEntity bagEntity = bagService.getBagEntityById(player.getBag().getId());
        return bagService.getItems(bagEntity).stream().map(Item::getName).toList();
    }

    public boolean isItemInBag(Player player, String itemName) {
        BagEntity bagEntity = bagService.getBagEntityById(player.getBag().getId());
        return bagService.getItems(bagEntity).stream().anyMatch(item -> item.getName().equals(itemName));
    }

    public ItemEntity getItemEntityFromBag(Player player, String itemName) {
        BagEntity bagEntity = bagService.getBagEntityById(player.getBag().getId());
        return bagService.getItemEntity(bagEntity, itemName);
    }

    public void removeItemFromBag(Player player, ItemEntity itemEntity) {
        BagEntity bagEntity = bagService.getBagEntityById(player.getBag().getId());
        bagService.removeItem(bagEntity, itemEntity);
    }
}
