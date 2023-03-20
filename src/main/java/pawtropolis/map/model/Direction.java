package pawtropolis.map.model;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction {

    NORTH("south"),
    SOUTH("north"),
    EAST("west"),
    WEST("east");

    private final String oppositeDirection;

    public Direction reverseDirection() {
        return valueOf(oppositeDirection.toUpperCase());
    }
}
