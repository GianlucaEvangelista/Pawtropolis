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
import java.util.List;

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

    public Bag getBagById(int id) {
        BagEntity bagEntity = bagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        return bagMarshaller.toBag(bagEntity);
    }

    public BagEntity saveBag(Bag bag) {
        return bagRepository.save(bagMarshaller.toBagEntity(bag));
    }

    @Transactional
    public void addItem(ItemEntity itemEntity, BagEntity bagEntity) {
        if(bagEntity.getAvailableSlots() - itemEntity.getRequiredSlots() >= 0) {
            bagEntity.getItemEntities().add(itemEntity);
            bagEntity.setAvailableSlots(bagEntity.getAvailableSlots() - itemEntity.getRequiredSlots());
            bagRepository.save(bagEntity);
        }
    }

    public boolean isThereEnoughSpace(BagEntity bagEntity, ItemEntity itemEntityToAdd) {
        return bagEntity.getAvailableSlots() >= itemEntityToAdd.getRequiredSlots();
    }

    public List<Item> getItems(BagEntity bagEntity) {
        List<Integer> itemsId = bagRepository.getItemsIdFromBag(bagEntity.getId());
        return itemsId.stream().map(itemService::getItemById).toList();
    }
}
