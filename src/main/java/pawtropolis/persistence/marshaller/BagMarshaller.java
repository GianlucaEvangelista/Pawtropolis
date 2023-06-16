package pawtropolis.persistence.marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.model.Bag;
import pawtropolis.game.model.Item;
import pawtropolis.persistence.model.BagEntity;
import java.util.List;

@Component
public class BagMarshaller {

    private final ItemMarshaller itemMarshaller;

    @Autowired
    public BagMarshaller(ItemMarshaller itemMarshaller) {
        this.itemMarshaller = itemMarshaller;
    }
    public BagEntity toBagEntity(Bag bag) {
        BagEntity bagEntity = new BagEntity();
        bagEntity.setAvailableSlots(bag.getAvailableSlots());
        bagEntity.setItemEntities(bag.getItems().stream().map(itemMarshaller::toItemEntity).toList());
        return bagEntity;
    }

    public Bag toBag(BagEntity bagEntity) {
        int availableSlots = bagEntity.getAvailableSlots();
        List<Item> items = bagEntity.getItemEntities().stream().map(itemMarshaller::toItem).toList();
        return new Bag(items, availableSlots);
    }
}
