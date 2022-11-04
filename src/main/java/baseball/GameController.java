package baseball;

import baseball.Input.InputManageable;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.regex.Pattern;

public class GameController {
    private static final Integer INPUT_SIZE = 3;
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 9;
    private static final String VALID_INPUT_PATTERN = "^[1-9]*$";
    private List<Integer> randomNumber;
    public GameController()
    {
        generateRandomNumber();
    }

    public void generateRandomNumber()
    {
        randomNumber = List.of(
                Randoms.pickNumberInRange(START_INCLUSIVE,END_INCLUSIVE),
                Randoms.pickNumberInRange(START_INCLUSIVE,END_INCLUSIVE),
                Randoms.pickNumberInRange(START_INCLUSIVE,END_INCLUSIVE));
    }

    public Integer getRandomNumber()
    {
        return randomNumber.get(0)*100 + randomNumber.get(1)*10 + randomNumber.get(2);
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
