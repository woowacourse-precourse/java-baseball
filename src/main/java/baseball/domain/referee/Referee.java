package baseball.domain.referee;

import baseball.domain.number.BaseballNumber;
import baseball.domain.score.Score;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Referee {
    private Score score;

    private void ruled(BaseballNumber original, List<BaseballNumber> target, Integer position) {
        AtomicInteger atomicInteger = new AtomicInteger();
        target.forEach(item -> {
            Integer targetPosition = atomicInteger.getAndIncrement();

            if (!original.equals(item)) {
                return;
            }
            if (targetPosition.equals(position)) {
                this.score = score.strike();
                return;
            }
            this.score = score.ball();
        });
    }

    public Score ruled(List<BaseballNumber> original, List<BaseballNumber> target) {
        this.score = Score.generateZero();
        AtomicInteger atomicInteger = new AtomicInteger();
        original.forEach(item -> ruled(item, target, atomicInteger.getAndIncrement()));
        return score;
    }
}
