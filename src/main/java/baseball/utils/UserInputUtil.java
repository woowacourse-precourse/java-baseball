package baseball.utils;

import baseball.validator.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

public class UserInputUtil {
    public static String readUserAnswer() {
        String userAnswer = Console.readLine();
        NumberValidator.validate(userAnswer);
        return userAnswer;
    }

    public static String readRestartAnswer() {
        String restartAnswer = Console.readLine();
        NumberValidator.number(restartAnswer);
        return restartAnswer;
    }
}
