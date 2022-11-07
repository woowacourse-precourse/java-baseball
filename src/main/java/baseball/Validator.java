package baseball;

import static baseball.Const.FINISH;
import static baseball.Const.RESTART;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Validator {

    private Set<Character> overlapChecker;

    public void validateInput(String input) {
        overlapChecker = new HashSet<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < 3; i++) {
            char number = input.charAt(i);
            if (isWrongNumber(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isWrongNumber(char number) {
        return isCharacter(number) || !overlapChecker.add(number);
    }

    private boolean isCharacter(char number) {
        return number < '1' || '9' < number;
    }

    public boolean userWantRestart(String input) {
        if (Objects.equals(input, RESTART)) {
            return true;
        } else if (Objects.equals(input, FINISH)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
