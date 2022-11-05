package baseball.calculate;

import baseball.domain.Ball;
import baseball.domain.Strike;
import java.util.LinkedHashSet;


public class BaseballCalculator {

    private final Ball ball = new Ball();
    private final Strike strike = new Strike();


    public int strikeJudgement(LinkedHashSet<Character> correctNum, LinkedHashSet<Character> inputNum) {

        strike.clearStrike();
        var inputNumIterator = inputNum.iterator();

        for (char character : correctNum) {
            if (character == inputNumIterator.next()) {
                strike.addStrike();
            }
        }

        return strike.strike();
    }

    public int ballJudgement(LinkedHashSet<Character> correctNum, LinkedHashSet<Character> inputNum) {

        strikeJudgement(correctNum, inputNum);
        ball.clearBall();

        for(char c : correctNum) {
            if(inputNum.contains(c)) {
                ball.addBall();
            }
        }

        return ball.ball() - strike.strike();
    }
}
