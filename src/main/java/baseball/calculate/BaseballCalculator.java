package baseball.calculate;

import java.util.Iterator;
import baseball.domain.Ball;
import baseball.domain.Strike;
import java.util.LinkedHashSet;


public class BaseballCalculator {

    private final Ball ball = new Ball();
    private final Strike strike = new Strike();

    public int strikeJudgement(LinkedHashSet<Character> correctNum, LinkedHashSet<Character> inputNum) {
        strike.clearStrike();
        Iterator<Character> inputNumIterator = inputNum.iterator();

        for (char character : correctNum) {
            if (character == inputNumIterator.next()) {
                strike.addStrike();
            }
        }

        return strike.strike();
    }

    public int ballJudgement(LinkedHashSet<Character> correctNum, LinkedHashSet<Character> inputNum) {
        ball.clearBall();

        Iterator<Character> inputNumIterator = inputNum.iterator();

        while(inputNumIterator.hasNext()) {
            if(correctNum.contains(inputNumIterator.next())) {
                ball.addBall();
            }
        }

        return ball.ball() - strike.strike();
    }
}
