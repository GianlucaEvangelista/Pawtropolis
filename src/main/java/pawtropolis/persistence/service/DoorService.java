package pawtropolis.persistence.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Door;
import pawtropolis.persistence.marshaller.DoorMarshaller;
import pawtropolis.persistence.model.DoorEntity;
import pawtropolis.persistence.model.ItemEntity;
import pawtropolis.persistence.repository.DoorRepository;
import pawtropolis.persistence.repository.ItemRepository;
import java.util.Optional;

@Service
public class DoorService {
    private final DoorRepository doorRepository;

    private final DoorMarshaller doorMarshaller;
    @Autowired
    public DoorService(DoorRepository doorRepository, DoorMarshaller doorMarshaller, ItemRepository itemRepository) {
        this.doorRepository = doorRepository;
        this.doorMarshaller = doorMarshaller;
    }

    public Door getDoorById(int id) {
        DoorEntity doorEntity = doorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Door not found"));

        return doorMarshaller.toDoor(doorEntity);
    }

    public DoorEntity getDoorEntityById(Integer id) {
        Optional<DoorEntity> optionalDoorEntity = doorRepository.findById(id);
        return optionalDoorEntity.orElse(null);
    }
    @Transactional
    public boolean unlockDoor(Door door) {
        DoorEntity doorEntity = getDoorEntityById(door.getId());
        doorEntity.setLocked(false);
        return !doorEntity.getLocked();
    }

    public boolean isTheRightKey(Door door, ItemEntity item) {
        DoorEntity doorEntity = getDoorEntityById(door.getId());
        return doorEntity.getKeyItemEntity().getName().equals(item.getName()) &&
                doorEntity.getKeyItemEntity().getDescription().equals(item.getDescription()) &&
                doorEntity.getKeyItemEntity().getRequiredSlots().equals(item.getRequiredSlots());
    }
}
