package pawtropolis.game;
import java.util.Scanner;

public final class InputController {


    private InputController() {}

    static Scanner input = new Scanner(System.in);

    public static String getInputString() {
        boolean isStringEmpty = true;
        String inputString = "";
        do {
            inputString = input.nextLine();
            if(!inputString.isEmpty()) {
                isStringEmpty = false;
            }
        } while(isStringEmpty);
        return inputString;
    }
}
