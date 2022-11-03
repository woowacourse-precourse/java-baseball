package baseball;

import baseball.domain.RandomBall;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RandomBall randomBall = new RandomBall();
        List<Integer> computerBalls = randomBall.makeRandomBalls();

    }
}
