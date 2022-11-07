package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomDigits extends Digits {
    private RandomDigits() {
        generateRandom();
    }

    public static RandomDigits createRandom() {
        return new RandomDigits();
    }

    private void generateRandom() {
        append(Digit.from(Randoms.pickNumberInRange(1, 9)));
        while (size() < 3) {
            tryToAppend();
        }
    }

    private void tryToAppend() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (!contains(Digit.from(randomNumber))) {
            append(Digit.from(randomNumber));
        }
    }
}
