package pawtropolis.map.model;

public enum Direction {

    NORTH("south"),
    SOUTH("north"),
    EAST("west"),
    WEST("east");

    private final String oppositeDirection;

    public String getOppositeDirection() {
        return oppositeDirection;
    }

    private Direction(String oppositeDirection) {
        this.oppositeDirection = oppositeDirection;
    }

    public Direction reverseDirection() {
        return valueOf(oppositeDirection.toUpperCase());
    }
}
