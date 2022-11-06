package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

import static constant.BaseballConstant.*;

public class BaseballNumber {

    public List<Integer> makeRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
