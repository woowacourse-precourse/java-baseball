package baseball.game_util;

import static baseball.common.Constants.MAX_USER_NUMBER_INPUT;

import baseball.common.Constants;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class InputUtil {

    public static int[] getUserThreeInputNumber() {
        String userInput = Console.readLine();
        checkUserInputValidate(userInput);

        return changeStringToIntArray(userInput);
    }

    private static void checkUserInputValidate(String userInput) {
        if (!isMaxLength(userInput)
                || !isDigit(userInput)
                || !isDuplicate(userInput)
                || !isInRange(userInput)) {
            throw new IllegalArgumentException();
        }

    }

    private static boolean isMaxLength(String userInput) {
        return (userInput.length() == MAX_USER_NUMBER_INPUT);
    }

    private static boolean isInRange(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicate(String userInput) {
        Set<Character> characterSet = new HashSet<>();
        for (Character character : userInput.toCharArray()) {
            characterSet.add(character);
        }
        return characterSet.size() == MAX_USER_NUMBER_INPUT;
    }

    private static boolean isDigit(String userInput) {
        return userInput.matches(Constants.VALID_NUMBER_PATTERN);
    }

    private static int[] changeStringToIntArray(String userInput) {
        return Stream.of(userInput.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
