package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Constants.*;
import static baseball.message.ExceptionMessage.*;

public class User {
    public String inputUserNumber() {
        String userInput = Console.readLine();
        checkValidate(userInput);
        return userInput;
    }

    public void checkValidate(String input) {
        validateInputRange(input);
        checkDuplicatedNumber(input);
        validateContainZero(input);
    }

    public void validateInputRange(String userInput) {
        String[] input = userInput.split("");
        if (input.length != 3) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERR_MSG);
        }
    }

    public void validateContainZero(String userInput) {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException(CONTAIN_ZERO_ERR_MSG);
        }
    }

    public void checkDuplicatedNumber (String userInput) {
        Set<String> userInputList = new HashSet<>(List.of(userInput.split("")));
        if (userInputList.size() != MAX_NUMBER_RESULT_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_ERR_MSG);
        }
    }
}
