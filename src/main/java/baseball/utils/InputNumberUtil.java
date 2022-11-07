package baseball.utils;

import baseball.constant.BaseballConstant;
import baseball.validation.UserValidator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.BaseballConstant.*;

public class InputNumberUtil {

    public static String inputNumber() {
        String userInput = Console.readLine();

        if (!UserValidator.inputNumberValidation(userInput)) {
            throw new IllegalArgumentException(WRONG_FORMAT_NUMBER);
        }

        return userInput;
    }
}
