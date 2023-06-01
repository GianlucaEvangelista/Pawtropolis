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

    public boolean containsItem(String itemName) {
        return getItems().stream().anyMatch(item -> item.getName().equals(itemName));
    }

    public Item getItem (String itemName) {
        return getItems().stream().filter(item -> item.getName().equals(itemName)).findFirst().orElse(null);
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
        List<String> adjacentRoomsList = new ArrayList<>();
        getAdjacentRooms().forEach((direction, pair) -> adjacentRoomsList.add(direction.getDirectionString().toUpperCase() + " " + pair.getFirst().getName() + " - " + (pair.getSecond().isOpen() ? "Open" : "Locked")));
        return String.join(", ", adjacentRoomsList);
    }

    public String getDescription() {
        return  "Room: " + this.getName() + "\n" +
                "Items: " + this.getItemsNames() + "\n" +
                "NPCs: " + this.getAnimalsNames() + "\n" +
                "Adjacent rooms: " + this.getAdjacentRoomsDescription();
    }
}
