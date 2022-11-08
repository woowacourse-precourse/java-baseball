package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class UserInputAdapter {
    public static List<Integer> changeStrToIntegerArray(String userInputStr) {
        InputValidator.hasValidType(userInputStr);
        List<Integer> userInput = new ArrayList<>();
        for (int i = 0; i < userInputStr.length(); i++) {
            userInput.add(userInputStr.charAt(i) - '0');
        }
        return userInput;
    }

    public static int changeStrToInt(String restartSignStr) {
        return Integer.parseInt(restartSignStr);
    }
}
