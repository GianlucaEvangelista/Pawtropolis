package pawtropolis.persistence.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.game.model.Bag;
import pawtropolis.persistence.marshaller.BagMarshaller;
import pawtropolis.persistence.model.BagEntity;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.repository.BagRepository;

@Service
public class BagService {

    private final BagRepository bagRepository;
    private final BagMarshaller bagMarshaller;

    @Autowired
    public BagService(BagRepository bagRepository, BagMarshaller bagMarshaller) {
        this.bagRepository = bagRepository;
        this.bagMarshaller = bagMarshaller;
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
}
