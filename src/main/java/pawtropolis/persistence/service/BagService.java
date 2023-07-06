package pawtropolis.persistence.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.game.model.Bag;
import pawtropolis.game.model.Item;
import pawtropolis.persistence.marshaller.BagMarshaller;
import pawtropolis.persistence.model.BagEntity;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.repository.BagRepository;
import java.util.Optional;

@Service
public class BagService {

    private final BagRepository bagRepository;
    private final BagMarshaller bagMarshaller;
    private final ItemService itemService;

    @Autowired
    public BagService(BagRepository bagRepository, BagMarshaller bagMarshaller, ItemService itemService) {
        this.bagRepository = bagRepository;
        this.bagMarshaller = bagMarshaller;
        this.itemService = itemService;
    }

    public BagEntity getBagEntityById(Integer id) {
        Optional<BagEntity> optionalBagEntity = bagRepository.findById(id);
        return optionalBagEntity.orElse(null);
    }

    public BagEntity saveBag(Bag bag) {
        return bagRepository.save(bagMarshaller.toBagEntity(bag));
    }

    @Transactional
    public void addItemEntity(Item item, BagEntity bagEntity) {
        ItemEntity itemEntity = itemService.getItemEntityById(item.getId());
        if(bagEntity.getAvailableSlots() - itemEntity.getRequiredSlots() >= 0) {
            bagEntity.getItemEntities().add(itemEntity);
            bagEntity.setAvailableSlots(bagEntity.getAvailableSlots() - itemEntity.getRequiredSlots());
            bagRepository.save(bagEntity);
        }
    }

    @Transactional
    public void removeItemEntity(BagEntity bagEntity, Item item) {
        ItemEntity itemEntity = itemService.getItemEntityById(item.getId());
        bagEntity.getItemEntities().removeIf(i -> i.getName().equals(itemEntity.getName()));
        bagEntity.setAvailableSlots(bagEntity.getAvailableSlots() + itemEntity.getRequiredSlots());
        bagRepository.save(bagEntity);
    }
}
