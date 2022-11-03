package baseball.model;

import baseball.utils.GameNumberGenerator;

import java.util.HashSet;
import java.util.Set;

import static baseball.resources.GameConfig.*;
import static baseball.resources.Sentence.*;

public class NumberBaseBallGame {
    private Set<Integer> gameNumber;
    private boolean isProceeding;

    public NumberBaseBallGame() {
        this.gameNumber = GameNumberGenerator.generate();
        this.isProceeding = true;
    }

    public boolean isProceeding() {
        return this.isProceeding;
    }

    public void inputNumberValidate(String inputNumber){
        validateThreeLength(inputNumber);
        validateDuplicate(inputNumber);
    }

    private void validateThreeLength(String inputNumber) {
        if (!inputNumber.matches(PATTERN)) {
            throwException(EXCEPTION);
        }
    }

    private void validateDuplicate(String inputNumber) {
        Set<Character> inputNumbers = new HashSet<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            inputNumbers.add(inputNumber.charAt(i));
        }

        if (inputNumbers.size() < SIZE) {
            throwException(EXCEPTION);
        }
    }
}
