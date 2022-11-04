package baseball.gamenumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation extends IllegalArgumentException {
    public Validation() {
    }

    public static void throwError() {
        throw new IllegalArgumentException();
    }

    public void isValidateInput(String input) {
        if (!(isThreeDigits(input))) {
            throwError();
        }
        if (isDuplicateString(input)) {
            throwError();
        }
        if (!(isNumeric(input))) {
            throwError();
        }
    }

    public boolean isThreeDigits(String input) {
        if (input.length() != 3) {
            return false;
        }
        return true;
    }

    public boolean isDuplicateString(String input) {
        Set<String> stringSet = new HashSet<>(List.of(input));
        if (stringSet.size() != 3) {
            return true;
        }
        return false;
    }

    public boolean isDuplicateList(List<Integer> list) {
        Set<Integer> integerSet = new HashSet<>(list);
        if (integerSet.size() != list.size()) {
            return true;
        }
        return false;
    }

    public boolean isNumeric(String input) {
        if (input.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }
}
