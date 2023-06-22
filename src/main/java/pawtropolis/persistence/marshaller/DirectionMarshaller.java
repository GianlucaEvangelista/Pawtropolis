package pawtropolis.persistence.marshaller;
import org.springframework.stereotype.Component;
import pawtropolis.map.model.Direction;
import pawtropolis.persistence.model.DirectionEntity;

@Component
public class DirectionMarshaller {

    public DirectionEntity toDirectionEntity(Direction direction) {
        DirectionEntity directionEntity = new DirectionEntity();
        directionEntity.setName(direction.getDirectionString());
        return directionEntity;
    }

    public Direction toDirection(DirectionEntity directionEntity) {
        String directionString = directionEntity.getName();
        return Direction.fromString(directionString);
    }
}
