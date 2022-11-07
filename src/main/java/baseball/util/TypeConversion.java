package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class TypeConversion {

    public static List<Integer> stringToIntList(String userInput) {
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < userInput.length(); index++) {
            int userInputIntValue = userInput.charAt(index) - '0';
            result.add(userInputIntValue);
        }

        return result;
    }

    public static int stringToInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}
