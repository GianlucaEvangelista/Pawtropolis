package pawtropolis.game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class InputController {

    private InputController() {}

    static Scanner input = new Scanner(System.in);

    public static String getPlayerName() {
        boolean nameIsEmpty = true;
        String playerName;
        do {
            System.out.println("Welcome to Pawtropolis! Insert Player's name:");
            playerName = input.nextLine();
            if(!playerName.isEmpty()) {
                nameIsEmpty = false;
            }
        } while(nameIsEmpty);

        return playerName;
    }

    public static List<String> getCommand() {
        boolean commandIsEmpty = true;
        List<String> chosenCommand = new ArrayList<>();
        do {
            System.out.println("Write one of the following commands:\n" +
                    "- go north/go east/go south/go west : change room\n" +
                    "- look: get a description of the current room\n" +
                    "- bag: get the list of the items inside the bag\n" +
                    "- get + item's name: put the item inside the bag\n" +
                    "- drop + item's name: drop the item\n" +
                    "- exit: end the game");
            String commandInput = input.nextLine().toLowerCase();
            if (!commandInput.isEmpty()) {
                chosenCommand = Arrays.asList(commandInput.split(" ", 2));
                commandIsEmpty = false;
            }
        } while(commandIsEmpty);
        return chosenCommand;
    }
}
