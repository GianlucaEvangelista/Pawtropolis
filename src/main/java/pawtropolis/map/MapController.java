package pawtropolis.map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Door;
import pawtropolis.map.model.Room;
import pawtropolis.utils.Pair;
import pawtropolis.game.model.Item;
import pawtropolis.zoo.model.Animal;
import pawtropolis.zoo.model.Eagle;
import pawtropolis.zoo.model.Lion;
import pawtropolis.zoo.model.Tiger;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@Component
public class MapController {

    @Getter(AccessLevel.NONE)
    private Room currentRoom;

    private MapController() {
        this.currentRoom = createMap();
    }

    private static Room createMap() {
        Room entrance = new Room("Entrance");
        Item flute = new Item("flute", "instrument to open doors", 5);
        entrance.addItem(flute);
        Room bedroom = new Room("Bedroom");
        Item mushrooms = new Item("mushrooms", "Argo's favourite food", 3);
        bedroom.addItem(mushrooms);
        bedroom.addAnimal(new Tiger("Arya", "salad", 10, LocalDate.of(2020,7,11), 260.00, 94.00, 86.50));
        bedroom.addAdjacentRoom(entrance, new Door(true, flute), Direction.WEST);
        Room kitchen = new Room("Kitchen");
        Item chips = new Item("chips", "Sky's favourite food", 1);
        kitchen.addItem(chips);
        kitchen.addAnimal(new Lion("Argo", "mushrooms", 9, LocalDate.of(2020,6,23), 192.10, 116.80, 92.10));
        kitchen.addAdjacentRoom(entrance, new Door(false, flute), Direction.SOUTH);
        Room livingRoom = new Room("Living room");
        Item violin = new Item("violin", "instrument to open doors", 7);
        livingRoom.addItem(violin);
        livingRoom.addAnimal(new Eagle("Sky", "chips", 3, LocalDate.of(2021,4,20), 4.50, 81.20, 210.10));
        livingRoom.addAdjacentRoom(entrance, new Door(true, violin), Direction.EAST);
        Room bathroom = new Room("Bathroom");
        Item salad = new Item("salad", "Arya's favourite food", 2);
        bathroom.addItem(salad);
        bathroom.addAdjacentRoom(livingRoom, new Door(false, violin), Direction.NORTH);
        return entrance;
    }

    public boolean currentRoomContainsItem(String itemName) {
        return currentRoom.getItems().stream().anyMatch(item -> item.getName().equals(itemName));
    }

    public Item getCurrentRoomItem (String itemName) {
        return currentRoom.getItems().stream().filter(item -> item.getName().equals(itemName)).findFirst().orElse(null);
    }

    public List<Item> getCurrentRoomItems() {
        return currentRoom.getItems();
    }

    public void addItemToCurrentRoom (String itemName, GameController gameController) {
        currentRoom.addItem(gameController.getPlayer().getItemInBag(itemName));
    }

    public void removeItemFromCurrentRoom (Item item) {
        currentRoom.removeItem(item);
    }

    public List<Animal> getCurrentRoomAnimals() {
        return currentRoom.getAnimals();
    }

    public String getCurrentRoomItemsNames() {
        String roomItems = "";
        if(!currentRoom.getItems().isEmpty()) {
            roomItems = getCurrentRoomItems().stream().map(Item::getName).collect(Collectors.joining(", "));
        }
        return roomItems;
    }

    public String getCurrentRoomAnimalsNames() {
        String roomAnimals = "";
        if(!currentRoom.getAnimals().isEmpty()) {
            roomAnimals = getCurrentRoomAnimals().stream()
                    .map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")")
                    .collect(Collectors.joining(", "));
        }
        return roomAnimals;
    }

    public String getCurrentRoomAdjacentRoomsNames() {
        if(currentRoom.getAdjacentRooms().isEmpty()) {
            return "there aren't adjacent rooms";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Direction, Pair<Room, Door>> entry : currentRoom.getAdjacentRooms().entrySet()) {
            Direction direction = entry.getKey();
            String roomName = entry.getValue().getFirst().getName();
            String doorIsOpen = entry.getValue().getSecond().isOpen() ? "open" : "locked";
            String template = "%s : %s (%s), ";
            String formattedEntry = String.format(template, direction, roomName, doorIsOpen);
            stringBuilder.append(formattedEntry);
        }
        if (stringBuilder.length() > 2) {
            stringBuilder.setLength(stringBuilder.length() - 2); //delete last ", " (2 characters)
        }
        return stringBuilder.toString();
    }

    public String getCurrentRoomDescription() {
        return  "You are in room " + this.getCurrentRoomName() + "\n" +
                "Items: " + this.getCurrentRoomItemsNames() + "\n" +
                "NPCs: " + this.getCurrentRoomAnimalsNames() + "\n" +
                "Adjacent rooms: " + this.getCurrentRoomAdjacentRoomsNames();
    }

    public String getCurrentRoomName() {
        return currentRoom.getName();
    }

    public Map<Direction, Pair<Room, Door>> getCurrentRoomAdjacentRooms() {
        return currentRoom.getAdjacentRooms();
    }

    public Room getCurrentRoomAdjacentRoom(Direction direction) {
        return currentRoom.getAdjacentRoom(direction);
    }

    public Door getCurrentRoomAdjacentRoomDoor(Direction direction) {
        return currentRoom.getAdjacentRoomDoor(direction);
    }
}
