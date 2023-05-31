package pawtropolis.map.model;
import lombok.*;
import pawtropolis.utils.Pair;
import pawtropolis.game.model.Item;
import pawtropolis.zoo.model.Animal;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Room {

    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private Map<Direction, Pair<Room, Door>> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new EnumMap<>(Direction.class);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.removeIf(a -> a.getName().equals(animal.getName()));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.removeIf(i -> i.getName().equals(item.getName()));
    }

    public void addAdjacentRoom(Room adjacentRoom, Door door, Direction direction) {
            if (adjacentRoom != null && !adjacentRooms.containsKey(direction) && adjacentRoom.linkAdjacentRoom(this, door, direction.reverseDirection())) {
                adjacentRooms.put(direction, new Pair<>(adjacentRoom, door));
            }
    }

    public boolean linkAdjacentRoom(Room room, Door door, Direction reverseDirection) {
        Pair<Room, Door> roomAndDoorInReverseDirection = adjacentRooms.computeIfAbsent(reverseDirection, key -> new Pair<>(room, door));
        return roomAndDoorInReverseDirection.getFirst() ==  room && roomAndDoorInReverseDirection.getSecond() == door;
    }

    public Room getAdjacentRoom(Direction direction) {
        return adjacentRooms.get(direction).getFirst();
    }

    public Door getAdjacentRoomDoor(Direction direction) {
        return adjacentRooms.get(direction).getSecond();
    }
}
