package pawtropolis.map;
import pawtropolis.player.Item;
import pawtropolis.zoo.Eagle;
import pawtropolis.zoo.Lion;
import pawtropolis.zoo.Tiger;
import java.time.LocalDate;

public class MapController {

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
        bedroom.addAdjacentRoom(entrance, "west");
        Room kitchen = new Room("Kitchen");
        kitchen.addItem(new Item("chips", "Sky's favourite food", 1));
        kitchen.addAnimal(new Lion("Argo", "mushrooms", 9, LocalDate.of(2020,6,23), 192.10, 116.80, 92.10));
        kitchen.addAdjacentRoom(entrance,"south");
        Room livingRoom = new Room("Living room");
        livingRoom.addItem(new Item("gun", "gun to kill big animals", 7));
        livingRoom.addAnimal(new Eagle("Sky", "chips", 3, LocalDate.of(2021,4,20), 4.50, 81.20, 210.10));
        livingRoom.addAdjacentRoom(entrance, "east");
        Room bathroom = new Room("Bathroom");
        bathroom.addItem(new Item("salad", "Arya's favourite food", 2));
        bathroom.addAdjacentRoom(livingRoom, "north");
        return entrance;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room playerRoom) {
        this.currentRoom = playerRoom;
    }
}
