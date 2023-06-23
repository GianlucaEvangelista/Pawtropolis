package pawtropolis.persistence.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Door;
import pawtropolis.persistence.marshaller.DoorMarshaller;
import pawtropolis.persistence.model.DoorEntity;
import pawtropolis.persistence.repository.DoorRepository;
import java.util.Optional;

@Service
public class DoorService {
    private final DoorRepository doorRepository;

    private final DoorMarshaller doorMarshaller;

    @Autowired
    public DoorService(DoorRepository doorRepository, DoorMarshaller doorMarshaller) {
        this.doorRepository = doorRepository;
        this.doorMarshaller = doorMarshaller;
    }

    public Door getDoorById(int id) {
        DoorEntity doorEntity = doorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Door not found"));

        return doorMarshaller.toDoor(doorEntity);
    }
    @Transactional
    public boolean unlockDoor(Door door) {
        Optional<DoorEntity> optionalDoorEntity = doorRepository.findById(door.getId());
        optionalDoorEntity.ifPresent(doorEntity -> doorEntity.setLocked(false));
        return optionalDoorEntity.filter(doorEntity -> !doorEntity.getLocked()).isPresent();
    }
}
