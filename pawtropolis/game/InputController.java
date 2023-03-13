package pawtropolis.game;
import java.util.Scanner;

public class InputController {

    Scanner input = new Scanner(System.in);

    public String getPlayerName() {
        System.out.println("Welcome to Pawtropolis! Insert Player's name:");
        return input.nextLine();
    }

    public String[] getCommand() {
        boolean commandIsEmpty = true;
        String[] chosenCommand;
        do {
            System.out.println("Write one of the following commands:\n" +
                    "- go north/go east/go south/go west : change room\n" +
                    "- look: get a description of the current room\n" +
                    "- bag: get the list of the items inside the bag\n" +
                    "- get + item's name: put the item inside the bag\n" +
                    "- drop + item's name: drop the item\n" +
                    "- exit: end the game");
            String commandInput = input.nextLine().toLowerCase();
            chosenCommand = commandInput.trim().split(" ");
            if (chosenCommand.length > 0) {
                commandIsEmpty = false;
            }
        } while(commandIsEmpty);
        return chosenCommand;
    }
}
