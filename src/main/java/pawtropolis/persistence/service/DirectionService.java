package pawtropolis.persistence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawtropolis.map.model.Direction;
import pawtropolis.persistence.marshaller.DirectionMarshaller;
import pawtropolis.persistence.model.DirectionEntity;
import pawtropolis.persistence.repository.DirectionRepository;

@Service
public class DirectionService {
    private final DirectionRepository directionRepository;

    private final DirectionMarshaller directionMarshaller;

    @Autowired
    public DirectionService(DirectionRepository directionRepository, DirectionMarshaller directionMarshaller) {
        this.directionRepository = directionRepository;
        this.directionMarshaller = directionMarshaller;
    }

    public Direction getDirectionById(int id) {
        DirectionEntity directionEntity = directionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Direction not found"));

        return directionMarshaller.toDirection(directionEntity);
    }
}
