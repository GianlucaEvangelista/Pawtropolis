package pawtropolis.map.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Direction {

    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west"),
    UNKNOWN("unknown");

    private final String directionString;

    private static final Map<Direction, Direction> OPPOSITE_DIRECTION = Map.of(NORTH, SOUTH, SOUTH, NORTH, EAST, WEST, WEST, EAST);

    public Direction reverseDirection() {
        return OPPOSITE_DIRECTION.get(this);
    }

    public static Direction fromString(String directionString) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getDirectionString().equals(directionString)).findFirst()
                .orElse(UNKNOWN);
    }
}
