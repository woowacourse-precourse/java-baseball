package baseball.calculate;

import baseball.domain.Ball;
import baseball.domain.Strike;
import java.util.LinkedHashSet;
import java.util.Iterator;


public class BaseballCalculator {

    private final Ball ball = new Ball();
    private final Strike strike = new Strike();


    public int strikeJudgement(LinkedHashSet<Character> correctNum, LinkedHashSet<Character> inputNum) {
        strike.clearStrike();
        Iterator<Character> inputIteration = inputNum.iterator();

        strike.putStrike((int) correctNum.stream()
                .filter(c -> c.equals(inputIteration.next()))
                .count());

        return strike.strike();
    }

    public int ballJudgement(LinkedHashSet<Character> correctNum, LinkedHashSet<Character> inputNum) {
        strikeJudgement(correctNum, inputNum);

        ball.clearBall();

        ball.putBall((int) correctNum.stream()
                .filter(c -> (inputNum.contains(c)))
                .count() - strike.strike());

        return ball.ball();
    }
}
