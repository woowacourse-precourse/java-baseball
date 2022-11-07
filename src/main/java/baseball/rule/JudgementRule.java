package baseball.rule;

import baseball.domain.BallCount;
import baseball.domain.Numbers;

public class JudgementRule {

    private static final int REGULAR_NUMBERS_SIZE = 3;
    private static final int NO_COUNT = 0;

    public static BallCount makeBallCounts(Numbers computerNumbers, Numbers userNumbers) {
        int strikes = NO_COUNT;
        int balls = NO_COUNT;
        for (int i = 0; i < REGULAR_NUMBERS_SIZE; i++) {
            if (computerNumbers.numbers.get(i).equals(userNumbers.numbers.get(i))) {
                strikes += 1;
                continue;
            }
            if (userNumbers.numbers.contains(computerNumbers.numbers.get(i))) {
                balls += 1;
            }
        }
        return new BallCount(strikes, balls);
    }

}
