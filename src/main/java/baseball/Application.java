package baseball;

import baseball.domain.MyBalls;
import baseball.domain.RandomBall;
import baseball.domain.ScoreBoard;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RandomBall randomBall = new RandomBall();
        List<Integer> computerBalls = randomBall.makeRandomBalls();
        System.out.println(computerBalls);

        MyBalls myBalls = new MyBalls();
        List<Integer> myBallNumbers = myBalls.inputBalls();

        ScoreBoard.judge(computerBalls, myBallNumbers);
    }
}
