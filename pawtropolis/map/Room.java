package pawtropolis.map;
import pawtropolis.player.Item;
import pawtropolis.zoo.Animal;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private Room[] adjacentRooms;

    public Room(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjacentRooms = new Room[4];
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

    public Room[] getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(Room[] adjacentRooms) {
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

    public void addAdjacentRoom(Room adjacentRoom, int direction) {
            if (adjacentRoom != null && direction >= 0 && direction < 4 && adjacentRooms[direction] == null && adjacentRoom.linkAdjacentRoom(this, direction)) {
                adjacentRooms[direction] = adjacentRoom;
            }
    }

    public boolean linkAdjacentRoom(Room room, int reverseDirection) {
        switch (reverseDirection) {
            case 0:
                if(adjacentRooms[2] == null) {
                    adjacentRooms[2] = room;
                    return true;
                }
                break;
            case 1:
                if(adjacentRooms[3] == null) {
                    adjacentRooms[3] = room;
                    return true;
                }
                break;
            case 2:
                if(adjacentRooms[0] == null) {
                    adjacentRooms[0] = room;
                    return true;
                }
                break;
            case 3:
                if(adjacentRooms[1] == null) {
                    adjacentRooms[1] = room;
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }
}
