package pawtropolis.persistence.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Door;
import pawtropolis.persistence.model.DoorEntity;
import pawtropolis.persistence.repository.DoorRepository;
import java.util.Optional;

@Service
public class DoorService {
    private final DoorRepository doorRepository;

    @Autowired
    public DoorService(DoorRepository doorRepository) {
        this.doorRepository = doorRepository;
    }

    public DoorEntity getDoorEntityById(Integer id) {
        Optional<DoorEntity> optionalDoorEntity = doorRepository.findById(id);
        return optionalDoorEntity.orElse(null);
    }

    @Transactional
    public void unlockDoorEntity(Door door) {
        DoorEntity doorEntity = getDoorEntityById(door.getId());
        doorEntity.setLocked(false);
    }
}
