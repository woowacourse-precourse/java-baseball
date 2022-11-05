package baseball.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.baseball.Digits.DIGIT_COUNT;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomBaseballGame {
    private final BaseballGame baseballGame;
    private Digits randomDigits;

    public RandomBaseballGame(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    private Digits createRandomDigits() {
        Set<Integer> selectedSet = new HashSet<>();
        List<Integer> randomList = new ArrayList<>();

        for (int i = 0; i < DIGIT_COUNT; i++) {
            int number;

            do {
                number = pickNumberInRange(1, 9);
            } while(selectedSet.contains(number));

            selectedSet.add(number);
            randomList.add(number);
        }

        return new Digits(randomList);
    }

    public void newGame() {
        randomDigits = createRandomDigits();
    }

    public Result match(Digits digits) {
        return baseballGame.match(digits, randomDigits);
    }
}
