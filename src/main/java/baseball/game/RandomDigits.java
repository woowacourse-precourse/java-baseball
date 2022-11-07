package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.config.GameConstants.BASEBALL_NUMBER_LENGTH;

public final class RandomDigits extends Digits {
    private RandomDigits() {
        generateRandom();
    }

    public static RandomDigits createRandom() {
        return new RandomDigits();
    }

    private void generateRandom() {
        append(Digit.from(Randoms.pickNumberInRange(1, 9)));
        while (size() < BASEBALL_NUMBER_LENGTH) {
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
