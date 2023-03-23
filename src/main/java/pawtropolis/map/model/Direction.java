package pawtropolis.map.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;
import java.util.EnumMap;
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

    private static final Map<Direction, Direction> OPPOSITE_DIRECTION = new EnumMap<>(Direction.class);

    static {
        OPPOSITE_DIRECTION.put(NORTH, SOUTH);
        OPPOSITE_DIRECTION.put(SOUTH, NORTH);
        OPPOSITE_DIRECTION.put(EAST, WEST);
        OPPOSITE_DIRECTION.put(WEST, EAST);
    }

    public Direction reverseDirection() {
        return OPPOSITE_DIRECTION.get(this);
    }

    public static Direction fromString(String directionString) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.directionString.equals(directionString)).findFirst()
                .orElse(UNKNOWN);
    }
}
