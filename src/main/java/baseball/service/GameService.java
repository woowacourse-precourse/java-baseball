package baseball.service;

import baseball.model.numbers.Numbers;
import baseball.model.strikeandball.StrikeAndBall;
import java.util.concurrent.atomic.AtomicInteger;

public class GameService {

    public StrikeAndBall compareAnswerNumberAndInputNumber(Numbers answerNumber, Numbers inputNumber) {

        AtomicInteger strike = new AtomicInteger();
        AtomicInteger ball = new AtomicInteger();

        for (int idx = 0 ; idx < answerNumber.size() ; idx++) {
            if (answerNumber.equals(inputNumber, idx)) strike.addAndGet(1);
            else if (answerNumber.contains(inputNumber, idx)) ball.addAndGet(1);
        }

        int strikeCount = strike.get();
        int ballCount = ball.get();

        return new StrikeAndBall(strikeCount, ballCount);
    }
}
