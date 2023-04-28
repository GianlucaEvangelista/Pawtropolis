package pawtropolis.game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class InputController {

    private static final String MENU = """
                Write one of the following commands:
                - go north/go east/go south/go west: change room
                - look: get a description of the current room
                - bag: get the list of the items inside the bag
                - get + item's name: put the item inside the bag
                - drop + item's name: drop the item
                - exit: end the game""";

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
        List<String> commandInput = new ArrayList<>();
        do {
            System.out.println(MENU);
            String commandInputString = input.nextLine().toLowerCase();
            if (!commandInputString.isEmpty()) {
                commandInput = Arrays.asList(commandInputString.split(" ", 2));
                commandIsEmpty = false;
            }
        } while(commandIsEmpty);
        return commandInput;
    }
}
