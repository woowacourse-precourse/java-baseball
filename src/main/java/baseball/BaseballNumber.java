package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

import static constant.BaseballConstant.*;

public class BaseballNumber {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    public List<Integer> makeRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public String inputUserNumber() {
        String userInput = Console.readLine();

        if (!InputValidator.isRightInput(userInput)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return userInput;
    }
}
