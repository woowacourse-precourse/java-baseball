package baseball.model.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class Computer {

    private static final int RANDOM_NUMBERS_LENGTH = 3;

    public Answer createAnswer() {
        final List<Character> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < RANDOM_NUMBERS_LENGTH) {
            final Character randomNumber =
                    Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return new Answer(randomNumbers);
    }
}
