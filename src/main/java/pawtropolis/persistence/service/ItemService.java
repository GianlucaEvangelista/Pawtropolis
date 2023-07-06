package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.repository.ItemRepository;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemEntity getItemEntityById(Integer id) {
        Optional<ItemEntity> optionalItemEntity = itemRepository.findById(id);
        return optionalItemEntity.orElse(null);
    }

}
