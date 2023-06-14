package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.game.model.Item;
import pawtropolis.persistence.marshaller.ItemMarshaller;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.repository.ItemRepository;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    private final ItemMarshaller itemMarshaller;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMarshaller itemMarshaller) {
        this.itemRepository = itemRepository;
        this.itemMarshaller = itemMarshaller;
    }

    public Item getItemById(int id) {
        ItemEntity itemEntity = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        return itemMarshaller.toItem(itemEntity);
    }

}
