package pawtropolis.map.model;
import lombok.*;
import pawtropolis.utils.Pair;
import pawtropolis.game.model.Item;
import pawtropolis.zoo.model.Animal;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Room {

    private Integer id;
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

    public boolean linkAdjacentRoom(Room room, Door door, Direction reverseDirection) {
        Pair<Room, Door> roomAndDoorInReverseDirection = adjacentRooms.computeIfAbsent(reverseDirection, key -> new Pair<>(room, door));
        return roomAndDoorInReverseDirection.getFirst() ==  room && roomAndDoorInReverseDirection.getSecond() == door;
    }

    public Room getAdjacentRoom(Direction direction) {
        return adjacentRooms.get(direction).getFirst();
    }

    public String getItemsNames() {
        String roomItems = "";
        if(!getItems().isEmpty()) {
            roomItems = getItems().stream().map(Item::getName).collect(Collectors.joining(", "));
        }
        return roomItems;
    }

    public String getAnimalsNames() {
        String roomAnimals = "";
        if(!getAnimals().isEmpty()) {
            roomAnimals = getAnimals().stream()
                    .map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")")
                    .collect(Collectors.joining(", "));
        }
        return roomAnimals;
    }

    public String getAdjacentRoomsDescription() {
        return getAdjacentRooms().entrySet().stream()
                .map(entry -> entry.getKey().getDirectionString().toUpperCase() + " " + entry.getValue().getFirst().getName() + " - " + (entry.getValue().getSecond().isLocked() ? "Locked" : "Unlocked"))
                .collect(Collectors.joining(", "));
    }

    public String getDescription() {
        return  "Room: " + this.getName() + "\n" +
                "Items: " + this.getItemsNames() + "\n" +
                "NPCs: " + this.getAnimalsNames() + "\n" +
                "Adjacent rooms: " + this.getAdjacentRoomsDescription();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem (String itemName) {
        return getItems().stream().filter(item -> item.getName().equals(itemName)).findFirst().orElse(null);
    }

    public void removeItem(Item item) {
        items.removeIf(i -> i.getName().equals(item.getName()));
    }
}
