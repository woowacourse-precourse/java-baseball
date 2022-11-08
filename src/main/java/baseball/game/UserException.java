package baseball.game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserException {

    private static List<String> gameOverNumberList = List.of("1", "2");

    public static void checkGameOverException(String gameOverNumber) {
        if (!gameOverNumberList.contains(gameOverNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkUserInputException(String userInputNumber) {
        if (isDuplication(userInputNumber) || isNotLength3(userInputNumber) || isNotInt(userInputNumber) || isContainZero(userInputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplication(String userInputNumber) {
        Set<String> deduplication = new HashSet<>(List.of(userInputNumber.split("")));
        return deduplication.size() != 3;
    }

    private static boolean isNotLength3(String userInputNumber) {
        int length = userInputNumber.length();
        return length != 3;
    }

    private static boolean isNotInt(String userInputNumber) {
        try {
            Integer.parseInt(userInputNumber);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean isContainZero(String userInputNumber) {
        return Arrays.asList(userInputNumber.split("")).contains("0");
    }
}
