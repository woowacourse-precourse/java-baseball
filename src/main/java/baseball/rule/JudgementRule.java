package baseball.rule;

import baseball.domain.Ball;
import baseball.domain.BallCount;
import baseball.domain.Numbers;
import baseball.domain.Strike;

public class JudgementRule {

    private static final int REGULAR_NUMBERS_SIZE = 3;

    public static BallCount makeBallCounts(Numbers computerNumbers, Numbers userNumbers) {
        Strike strikes = new Strike(0);
        Ball balls = new Ball(0);
        for (int i = 0; i < REGULAR_NUMBERS_SIZE; i++) {
            if (computerNumbers.numbers.get(i).equals(userNumbers.numbers.get(i))) {
                strikes.addCount();
                continue;
            }
            if (userNumbers.numbers.contains(computerNumbers.numbers.get(i))) {
                balls.addCount();
            }
        }
        return new BallCount(strikes.getCount(), balls.getCount());
    }

}
