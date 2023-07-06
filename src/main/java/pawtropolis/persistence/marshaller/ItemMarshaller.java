package pawtropolis.persistence.marshaller;
import org.springframework.stereotype.Component;
import pawtropolis.game.model.Item;
import pawtropolis.persistence.model.ItemEntity;

@Component
public class ItemMarshaller {

    public ItemEntity toItemEntity(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName(item.getName());
        itemEntity.setDescription(item.getDescription());
        itemEntity.setRequiredSlots(item.getRequiredSlots());
        return itemEntity;
    }

    public Item toItem(ItemEntity itemEntity) {
        Integer id = itemEntity.getId();
        String itemName = itemEntity.getName();
        String itemDescription = itemEntity.getDescription();
        int itemRequiredSlots = itemEntity.getRequiredSlots();
        return new Item(id, itemName, itemDescription, itemRequiredSlots);
    }
}
