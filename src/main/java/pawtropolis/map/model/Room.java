package pawtropolis.map.model;
import lombok.*;
import pawtropolis.player.Item;
import pawtropolis.zoo.model.Animal;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Room {

    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private Map<Direction, Room> adjacentRooms;

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

    public void addAdjacentRoom(Room adjacentRoom, Direction direction) {
            if (adjacentRoom != null && !adjacentRooms.containsKey(direction) && adjacentRoom.linkAdjacentRoom(this, direction.reverseDirection())) {
                adjacentRooms.put(direction, adjacentRoom);
            }
    }

    public boolean linkAdjacentRoom(Room room, Direction reverseDirection) {
        Room roomInReverseDirection = adjacentRooms.computeIfAbsent(reverseDirection, key -> room);
        return roomInReverseDirection == room;
    }
}
