package pawtropolis.command;
import pawtropolis.game.GameController;
import pawtropolis.game.InputController;

public class CommandController {

    private InputController inputController;
    private GameController gameController;

    public CommandController(GameController gameController) {
        this.inputController = new InputController();
        this.gameController = gameController;
    }

    public InputController getInputController() {
        return inputController;
    }

    public void setInputController(InputController inputController) {
        this.inputController = inputController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public boolean executeCommand(GameController gameController) {
        boolean commandIsValid = false;
        boolean wantToExitGame = false;
        do {
            String[] chosenCommand = inputController.getCommand();
            switch (chosenCommand[0]) {
                case "go":
                    commandIsValid = executeGoCommand(gameController, chosenCommand);
                    break;
                case "look":
                    commandIsValid = executeLookCommand(gameController, chosenCommand);
                    break;
                case "bag":
                    commandIsValid = executeBagCommand(gameController, chosenCommand);
                    break;
                case "get":
                    commandIsValid = executeGetCommand(gameController, chosenCommand);
                    break;
                case "drop":
                    commandIsValid = executeDropCommand(gameController, chosenCommand);
                    break;
                case "exit":
                    commandIsValid = true;
                    wantToExitGame = true;
                    System.out.println("Goodbye " + gameController.getPlayer().getName() + "!");
                    break;
                default:
                    System.out.println("Command not valid!");
                    break;
            }
        } while(!commandIsValid);
        return wantToExitGame;
    }

    public static boolean executeGoCommand(GameController gameController, String[] chosenCommand) {
        boolean executionIsDone = false;
        if(chosenCommand.length > 1) {
            executionIsDone = new GoCommand(gameController).execute(gameController, chosenCommand[1]);
            if(executionIsDone) {
                executionIsDone = new LookCommand(gameController).execute(gameController, "");
            }
        }
        return executionIsDone;
    }

    public static boolean executeLookCommand(GameController gameController, String[] chosenCommand) {
        boolean executionIsDone = false;
        if(chosenCommand.length == 1) {
            executionIsDone = new LookCommand(gameController).execute(gameController, "");
        }
        return executionIsDone;
    }

    public static boolean executeBagCommand(GameController gameController, String[] chosenCommand) {
        boolean executionIsDone = false;
        if(chosenCommand.length == 1) {
            executionIsDone = new BagCommand(gameController).execute(gameController, "");
        }
        return executionIsDone;
    }

    public static boolean executeGetCommand(GameController gameController, String[] chosenCommand) {
        boolean executionIsDone = false;
        if(chosenCommand.length > 1) {
            executionIsDone = new GetCommand(gameController).execute(gameController, chosenCommand[1]);
        }
        return executionIsDone;
    }

    public static boolean executeDropCommand(GameController gameController, String[] chosenCommand) {
        boolean executionIsDone = false;
        if(chosenCommand.length > 1) {
            executionIsDone = new DropCommand(gameController).execute(gameController, chosenCommand[1]);
        }
        return executionIsDone;
    }
}
