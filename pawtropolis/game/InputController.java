package pawtropolis.game;

import java.util.Scanner;

public class InputController {

    Scanner input = new Scanner(System.in);

    public String getPlayerName() {
        System.out.println("Welcome to Pawtropolis! Insert Player's name:");
        return input.nextLine();
    }
}
