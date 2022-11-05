package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BallGenerator {
    public static final int DIGIT_NUMBER = 3;
    private final InputValidator inputValidator = new InputValidator();

    public Set<Integer> generateRandom() {
        Set<Integer> target = new LinkedHashSet<>();
        while (target.size() < DIGIT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            target.add(randomNumber);
        }
        return target;
    }

    public List<Integer> generateGuessValue(String input) {
        inputValidator.validateGuessValueMessage(input);
        List<Integer> guessValue = new ArrayList<>();
        for (int i = 0; i < DIGIT_NUMBER; i++) {
            guessValue.add(input.charAt(i) - '0');
        }
        return guessValue;
    }
}
