package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Door;
import pawtropolis.persistence.marshaller.DoorMarshaller;
import pawtropolis.persistence.model.DoorEntity;
import pawtropolis.persistence.repository.DoorRepository;

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
}
