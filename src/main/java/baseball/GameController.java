package baseball;

import baseball.Input.InputManageable;

import java.util.regex.Pattern;

public class GameController {
    private static final Integer INPUT_SIZE = 3;
    private static final String VALID_INPUT_PATTERN = "^[1-9]*$";
    public GameController()
    {

    }

    public boolean isValidUserInput(String userInput)
    {
        if (userInput.length() != INPUT_SIZE || !Pattern.matches(VALID_INPUT_PATTERN,userInput))
        {
            return false;
        }

        return true;
    }


}
