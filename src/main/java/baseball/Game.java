package baseball;

import baseball.model.Ball;

public class Game {


    public boolean isCorrectAllNumber(Ball ball) {
        return ball.getStrike() == 3;
    }

}
