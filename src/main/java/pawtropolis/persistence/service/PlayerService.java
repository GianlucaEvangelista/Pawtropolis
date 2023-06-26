package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.game.model.Item;
import pawtropolis.game.model.Player;
import pawtropolis.persistence.marshaller.PlayerMarshaller;
import pawtropolis.persistence.model.BagEntity;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.model.PlayerEntity;
import pawtropolis.persistence.repository.BagRepository;
import pawtropolis.persistence.repository.PlayerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMarshaller playerMarshaller;
    private final BagService bagService;
    private final BagRepository bagRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PlayerMarshaller playerMarshaller, BagService bagService, BagRepository bagRepository) {
        this.playerRepository = playerRepository;
        this.playerMarshaller = playerMarshaller;
        this.bagService = bagService;
        this.bagRepository = bagRepository;
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
        Optional<BagEntity> optionalBagEntity = bagRepository.findById(player.getBag().getId());
        optionalBagEntity.ifPresent(bagEntity -> bagService.addItem(itemEntity, bagEntity));
    }

    public boolean hasEnoughSpaceInBag(ItemEntity itemEntityToAdd, Player player) {
        Optional<BagEntity> optionalBagEntity = bagRepository.findById(player.getBag().getId());
        return optionalBagEntity.filter(bagEntity -> bagService.isThereEnoughSpace(bagEntity, itemEntityToAdd)).isPresent();
    }

    public List<String> getItemsFromBag(Player player) {
        Optional<BagEntity> optionalBagEntity = bagRepository.findById(player.getBag().getId());
        List<String> items = new ArrayList<>();
        optionalBagEntity.ifPresent(bagEntity -> {
            items.addAll(bagService.getItems(bagEntity).stream().map(Item::getName).toList());
        });
        return items;
    }

    public boolean isItemInBag(Player player, String itemName) {
        Optional<BagEntity> optionalBagEntity = bagRepository.findById(player.getBag().getId());
        return optionalBagEntity.filter(bagEntity -> bagService.getItems(bagEntity).stream().anyMatch(item -> item.getName().equals(itemName))).isPresent();
    }

    public ItemEntity getItemEntityFromBag(Player player, String itemName) {
        Optional<BagEntity> optionalBagEntity = bagRepository.findById(player.getBag().getId());
        if(optionalBagEntity.isPresent()) {
            BagEntity bagEntity = optionalBagEntity.get();
            return bagService.getItemEntity(bagEntity, itemName);
        } else {
            return null;
        }
    }

    public void removeItemFromBag(Player player, ItemEntity itemEntity) {
        Optional<BagEntity> optionalBagEntity = bagRepository.findById(player.getBag().getId());
        optionalBagEntity.ifPresent(bagEntity -> bagService.removeItem(bagEntity, itemEntity));
    }
}
