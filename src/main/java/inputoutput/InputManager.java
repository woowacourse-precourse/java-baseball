package inputoutput;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private Validation validator;

    public InputManager() {
        validator = new Validation();
    }

    public String getPlayerNumber() {
        OutputManager.requestPlayerNumber();
        String playerNumber = Console.readLine();

        if (validator.checkPlayerNumber(playerNumber)) {
            return playerNumber;
        }

        throw new IllegalArgumentException();
    }

    public String getPlayerChoice() {
        OutputManager.requestPlayerChoice();
        String playerChoice = Console.readLine();

        return playerChoice;
    }
}
