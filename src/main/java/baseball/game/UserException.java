package baseball.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserException {

    private static boolean isDuplication(String userInputNumber) {
        Set<String> deduplication = new HashSet<>(List.of(userInputNumber.split("")));
        return deduplication.size() != 3;
    }
}
