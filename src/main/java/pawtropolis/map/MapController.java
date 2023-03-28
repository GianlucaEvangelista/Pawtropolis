package pawtropolis.map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import pawtropolis.game.GameController;
import pawtropolis.map.model.Direction;
import pawtropolis.map.model.Room;
import pawtropolis.player.Item;
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
public class MapController {

    @Getter(AccessLevel.NONE)
    private Room currentRoom;

    public MapController() {
        this.currentRoom = createMap();
    }

    private static Room createMap() {
        Room entrance = new Room("Entrance");
        entrance.addItem(new Item("knife", "knife to kill small animals", 5));
        Room bedroom = new Room("Bedroom");
        bedroom.addItem(new Item("mushrooms", "Argo's favourite food", 3));
        bedroom.addAnimal(new Tiger("Arya", "salad", 10, LocalDate.of(2020,7,11), 260.00, 94.00, 86.50));
        bedroom.addAdjacentRoom(entrance, Direction.WEST);
        Room kitchen = new Room("Kitchen");
        kitchen.addItem(new Item("chips", "Sky's favourite food", 1));
        kitchen.addAnimal(new Lion("Argo", "mushrooms", 9, LocalDate.of(2020,6,23), 192.10, 116.80, 92.10));
        kitchen.addAdjacentRoom(entrance,Direction.SOUTH);
        Room livingRoom = new Room("Living room");
        livingRoom.addItem(new Item("gun", "gun to kill big animals", 7));
        livingRoom.addAnimal(new Eagle("Sky", "chips", 3, LocalDate.of(2021,4,20), 4.50, 81.20, 210.10));
        livingRoom.addAdjacentRoom(entrance, Direction.EAST);
        Room bathroom = new Room("Bathroom");
        bathroom.addItem(new Item("salad", "Arya's favourite food", 2));
        bathroom.addAdjacentRoom(livingRoom, Direction.NORTH);
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

    public String getCurrentRoomDescription(GameController gameController) {
        String roomItems = "";
        String roomNPCs = "";
        if(!currentRoom.getItems().isEmpty()) {
            roomItems = gameController.getMapController().getCurrentRoomItems().stream()
                    .map(Item::getName).collect(Collectors.joining(", "));
        }
        if(!currentRoom.getAnimals().isEmpty()) {
            roomNPCs = gameController.getMapController().getCurrentRoomAnimals().stream()
                    .map(animal -> animal.getName() + " (" + animal.getClass().getSimpleName() + ")")
                    .collect(Collectors.joining(", "));
        }
        return  "Items: " + roomItems + "\n" + "NPCs: " + roomNPCs;
    }

    public String getCurrentRoomName() {
        return currentRoom.getName();
    }

    public Map<Direction, Room> getCurrentRoomAdjacentRooms() {
        return currentRoom.getAdjacentRooms();
    }
}
