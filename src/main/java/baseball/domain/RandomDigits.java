package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDigits extends Digits {
    private RandomDigits() {
        super();
        generateRandom();
    }

    public static RandomDigits createRandom() {
        return new RandomDigits();
    }

    private void generateRandom() {
        while (size() < 3) {
            tryToAppend();
        }
    }

    private void tryToAppend() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!contains(Digit.from(randomNumber))) {
            append(Digit.from(randomNumber));
        }
    }
}
