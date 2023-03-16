package pawtropolis.map.model;
import pawtropolis.player.Item;
import pawtropolis.zoo.model.Animal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private Map<String, Room> adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Map<String, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(Map<String, Room> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
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

    public void addAdjacentRoom(Room adjacentRoom, String direction) {
            if (adjacentRoom != null && !direction.isEmpty() && !adjacentRooms.containsKey(direction) && adjacentRoom.linkAdjacentRoom(this, direction)) {
                adjacentRooms.put(direction, adjacentRoom);
            }
    }

    public boolean linkAdjacentRoom(Room room, String reverseDirection) {
        switch (reverseDirection) {
            case "north":
                if (!adjacentRooms.containsKey("south")) {
                    adjacentRooms.put("south", room);
                    return true;
                }
                break;
            case "south":
                if (!adjacentRooms.containsKey("north")) {
                    adjacentRooms.put("north", room);
                    return true;
                }
                break;
            case "east":
                if (!adjacentRooms.containsKey("west")) {
                    adjacentRooms.put("west", room);
                    return true;
                }
                break;
            case "west":
                if (!adjacentRooms.containsKey("east")) {
                    adjacentRooms.put("east", room);
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }
}
