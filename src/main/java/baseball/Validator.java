package baseball;

import static baseball.Const.BALL_LENGTH;
import static baseball.Const.FINISH;
import static baseball.Const.INPUT_3_NUMBERS;
import static baseball.Const.INPUT_WITHOUT_OVERLAP;
import static baseball.Const.ONLY_NUMBER;
import static baseball.Const.RESTART;
import static baseball.Const.RESTART_1_FINISH_2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Validator {

    private Set<Character> overlapChecker;

    public void validateInput(String input) {
        overlapChecker = new HashSet<>();

        if (input.length() != BALL_LENGTH) {
            throw new IllegalArgumentException(INPUT_3_NUMBERS);
        }

        for (int i = 0; i < BALL_LENGTH; i++) {
            char number = input.charAt(i);
            checkInput(number);
        }
    }

    private void checkInput(char number) {
        checkCharacter(number);
        checkOverlap(number);
    }

    private void checkOverlap(char number) {
        if (!overlapChecker.add(number)) {
            throw new IllegalArgumentException(INPUT_WITHOUT_OVERLAP);
        }
    }

    private void checkCharacter(char number) {
        if (number < '1' || '9' < number) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    public boolean userWantRestart(String input) {
        if (Objects.equals(input, RESTART)) {
            return true;
        } else if (Objects.equals(input, FINISH)) {
            return false;
        } else {
            throw new IllegalArgumentException(RESTART_1_FINISH_2);
        }
    }

}
