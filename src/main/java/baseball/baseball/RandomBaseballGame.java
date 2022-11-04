package baseball.baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.baseball.Digits.DIGIT_COUNT;

public class RandomBaseballGame {
    private final BaseballGame baseballGame;
    private Digits randomDigits;

    public RandomBaseballGame(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    private Digits createRandomDigits() {
        return new Digits(Randoms.pickUniqueNumbersInRange(1, 9, DIGIT_COUNT));
    }

    public void newGame() {
        randomDigits = createRandomDigits();
    }
}
