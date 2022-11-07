package baseball.game_util;

import static baseball.common.Constants.MAX_USER_NUMBER_INPUT;

import baseball.common.Constants;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputUtil {

    public static List<Integer> getUserThreeInputNumber() {
        String userInput = Console.readLine();
        checkUserInputValidate(userInput);

        return changeStringToIntegerList(userInput);
    }

    private static void checkUserInputValidate(String userInput) {
        if (!isMaxLength(userInput)
                || !isDigit(userInput)
                || !isDuplicate(userInput)) {
            throw new IllegalArgumentException();
        }

    }

    private static boolean isMaxLength(String userInput) {
        return (userInput.length() == MAX_USER_NUMBER_INPUT);
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

    private static List<Integer> changeStringToIntegerList(String userInput) {
        return Arrays.stream(userInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
