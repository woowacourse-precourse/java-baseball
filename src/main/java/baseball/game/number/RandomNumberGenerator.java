package baseball.game.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public GameNumber generate() {
        List<Integer> digits = generateDigitsForNumber();
        return new GameNumber(digits);
    }

    private List<Integer> generateDigitsForNumber() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < GameNumber.FULL_SIZE) {
            addUniqueRandomDigit(digits);
        }
        return digits;
    }

    private void addUniqueRandomDigit(List<Integer> digits) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!digits.contains(randomNumber)) {
            digits.add(randomNumber);
        }
    }
}
