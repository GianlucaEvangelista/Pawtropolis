package pawtropolis.map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Door;
import pawtropolis.map.model.Room;
import pawtropolis.persistence.service.AnimalService;
import pawtropolis.persistence.service.ItemService;
import pawtropolis.utils.Pair;
import pawtropolis.game.model.Item;
import pawtropolis.zoo.model.Animal;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component
public class MapController {

    @Getter(AccessLevel.NONE)
    private Room currentRoom;

    private final ItemService itemService;
    private final AnimalService animalService;

    @Autowired
    private MapController(ItemService itemService, AnimalService animalService) {
        this.itemService = itemService;
        this.animalService = animalService;
        this.currentRoom = createMap();
    }

    private Room createMap() {
        Room entrance = new Room("Entrance");
        entrance.addItem(itemService.getItemById(1));
        Room bedroom = new Room("Bedroom");
        Item mushrooms = new Item("mushrooms", "Argo's favourite food", 3);
        bedroom.addItem(mushrooms);
        bedroom.addAnimal(animalService.getAnimalById(1));
        bedroom.addAdjacentRoom(entrance, new Door(false, itemService.getItemById(1)), Direction.WEST);
        Room kitchen = new Room("Kitchen");
        Item chips = new Item("chips", "Sky's favourite food", 1);
        kitchen.addItem(chips);
        kitchen.addAnimal(animalService.getAnimalById(2));
        kitchen.addAdjacentRoom(entrance, new Door(true, itemService.getItemById(1)), Direction.SOUTH);
        Room livingRoom = new Room("Living room");
        Item violin = new Item("violin", "instrument to open doors", 7);
        livingRoom.addItem(violin);
        livingRoom.addAnimal(animalService.getAnimalById(3));
        livingRoom.addAdjacentRoom(entrance, new Door(false, violin), Direction.EAST);
        Room bathroom = new Room("Bathroom");
        Item salad = new Item("salad", "Arya's favourite food", 2);
        bathroom.addItem(salad);
        bathroom.addAdjacentRoom(livingRoom, new Door(true, violin), Direction.NORTH);
        return entrance;
    }

    public boolean currentRoomContainsItem(String itemName) {
        return currentRoom.containsItem(itemName);
    }

    public Item getCurrentRoomItem (String itemName) {
        return currentRoom.getItem(itemName);
    }

    public List<Item> getCurrentRoomItems() {
        return currentRoom.getItems();
    }

    public void addItemToCurrentRoom (Item item) {
        currentRoom.addItem(item);
    }

    public void removeItemFromCurrentRoom (Item item) {
        currentRoom.removeItem(item);
    }

    public List<Animal> getCurrentRoomAnimals() {
        return currentRoom.getAnimals();
    }

    public String getCurrentRoomItemsNames() {
        return currentRoom.getItemsNames();
    }

    public String getCurrentRoomAnimalsNames() {
        return currentRoom.getAnimalsNames();
    }

    public String getCurrentRoomAdjacentRoomsDescription() {
        return currentRoom.getAdjacentRoomsDescription();
    }

    public String getCurrentRoomDescription() {
        return  currentRoom.getDescription();
    }

    public Map<Direction, Pair<Room, Door>> getCurrentRoomAdjacentRooms() {
        return currentRoom.getAdjacentRooms();
    }

    public Door getCurrentRoomAdjacentRoomDoor(Direction direction) {
        return currentRoom.getAdjacentRoomDoor(direction);
    }

    public void changeRoom(Direction direction) {
        Room nextRoom = currentRoom.getAdjacentRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
        }
    }
}


