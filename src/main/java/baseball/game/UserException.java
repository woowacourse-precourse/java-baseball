package baseball.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserException {

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
}
