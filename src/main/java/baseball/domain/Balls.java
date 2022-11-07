package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    public static final int BALLS_SIZE = Position.MAX_POSITION - Position.MIN_POSITION + 1;
    public static final String ERROR_MESSAGE_OUT_OF_RANGE_BALLS_SIZE = "입력 가능한 공의 갯수는 " + BALLS_SIZE + "개 입니다.";
    private List<Ball> balls = new ArrayList<>();

    private Balls() {
    }

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls create() {
        Balls balls = new Balls();
        while (balls.currentBallsSize() < BALLS_SIZE) {
            balls.addRandomBall();
        }
        return balls;
    }

    public static Balls from(String input) {
        String[] ballsArray = input.split("");

        if (ballsArray.length > BALLS_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE_BALLS_SIZE);
        }

        List<Ball> balls = new ArrayList<>();

        for (int position = Position.MIN_POSITION; position <= BALLS_SIZE; position++) {
            balls.add(
                    Ball.of(Number.from(ballsArray[position - 1]), Position.from(position)));
        }
        return new Balls(balls);
    }

    public List<Integer> getBallNumbers() {
        List<Integer> ballNumbers = new ArrayList<>();
        balls.forEach(ball -> ballNumbers.add(ball.number()));
        return ballNumbers;
    }

    private void addRandomBall() {
        validateRandomBall();
        int number = getRandomNumber();
        int position = currentBallsSize() + 1;
        balls.add(Ball.of(Number.from(number), Position.from(position)));
    }

    private int getRandomNumber() {
        List<Integer> ballNumbers = getBallNumbers();
        int newNumber = Number.getRandomNumber();
        while (ballNumbers.contains(newNumber)) {
            newNumber = Number.getRandomNumber();
        }
        return newNumber;
    }

    private void validateRandomBall() {
        if (currentBallsSize() >= BALLS_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE_BALLS_SIZE);
        }
    }

    private int currentBallsSize() {
        return this.balls.size();
    }

    public Ball getBallByPosition(Position value) {
        int position = value.value() - 1;
        return balls.get(position);
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
