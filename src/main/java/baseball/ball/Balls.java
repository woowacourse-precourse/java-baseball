package baseball.ball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final int BALL_SIZE = 3;
    private static final String NOT_BALL_SIZE="3 개의 숫자를 입력해주세요";
    private List<Ball> balls;

    public Balls() {
        balls = new ArrayList<>();
    }

    public boolean equalBallsSize() {
        if(balls.size()==BALL_SIZE){
            return true;
        }
        return false;
    }

    public void validatePlayerBallSize(){
        if(balls.size()!=BALL_SIZE){
            throw new IllegalArgumentException(NOT_BALL_SIZE);
        }
    }

    public boolean hasBall(Ball ball) {
        return balls.stream()
                .anyMatch(x -> x.getBallNumber() == ball.getBallNumber());
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public List<Ball> getBalls() {
        return balls;
    }
}