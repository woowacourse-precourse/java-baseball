package baseball.model.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation extends IllegalArgumentException {
    private static final String ZERO = "0";
    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private static final int NUMBER_DIGITS = 3;

    public Validation() {
    }

    public void throwError() {
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
        if (hasZero(input)) {
            throwError();
        }
    }

    public boolean isThreeDigits(String input) {
        if (input.length() != NUMBER_DIGITS) {
            return false;
        }
        return true;
    }

    public boolean isDuplicateString(String input) {
        Set<String> stringSet = new HashSet<>(Arrays.asList(input.split("")));
        if (stringSet.size() != NUMBER_DIGITS) {
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

    public boolean hasZero(String input) {
        if (input.contains(ZERO)) {
            return true;
        }
        return false;
    }

    public void isValidateReplayInput(String input) {
        if (!input.equals(RESTART) && !input.equals(EXIT)) {
            throwError();
        }
    }
}