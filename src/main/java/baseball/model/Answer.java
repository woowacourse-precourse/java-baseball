package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    public static final int ANSWER_SIZE = BallPosition.MAX_POSITION - BallPosition.MIN_POSITION + 1;
    public static final String ERROR_MESSAGE_OF_OUT_OF_RANGE_ANSWER_SIZE = "입력 가능한 공의 갯수는 " + ANSWER_SIZE + "개 입니다.";

    private List<Ball> balls = new ArrayList<>();

    private Answer(List<Ball> balls) {
        this.balls = balls;
    }

    private Answer() {
    }

    public static Answer create() {
        Answer answer = new Answer();

        while (answer.currentAnswerSize() < ANSWER_SIZE) {
            answer.addNewRandomBall();
        }

        return answer;
    }

    public static Answer fromString(String ballNumberString) {
        String[] ballNumberArray = ballNumberString.split("");

        if (ballNumberArray.length > ANSWER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_OUT_OF_RANGE_ANSWER_SIZE);
        }

        List<Ball> balls = new ArrayList<>();

        for (int position = BallPosition.MIN_POSITION; position <= ANSWER_SIZE; position++) {
            balls.add(
                    Ball.of(BallPosition.from(position),
                            BallNumber.from(Integer.parseInt(ballNumberArray[position - 1]))));
        }
        return new Answer(balls);
    }

    public List<Integer> getBallNumberValues() {
        List<Integer> ballNumbers = new ArrayList<>();

        balls.forEach(ball -> ballNumbers.add(ball.number()));

        return ballNumbers;

    }

    private void addNewRandomBall() {
        validateAddNewBall();

        int newBallPosition = currentAnswerSize() + 1;
        int newBallNumber = getUniqueRandomBallNumber();

        Ball newBall = Ball.of(
                BallPosition.from(newBallPosition),
                BallNumber.from(newBallNumber)
        );

        this.balls.add(newBall);
    }

    private int getUniqueRandomBallNumber() {
        int randomBallNumberValue = 0;
        boolean isDuplicatedBallNumber = true;
        List<Integer> alreadyExistBallNumberValues = this.getBallNumberValues();

        while (isDuplicatedBallNumber) {
            randomBallNumberValue = BallNumber.createRandomBallNumberValue();
            isDuplicatedBallNumber = alreadyExistBallNumberValues.contains(randomBallNumberValue);
        }

        return randomBallNumberValue;
    }

    private void validateAddNewBall() {
        if (currentAnswerSize() >= ANSWER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_OUT_OF_RANGE_ANSWER_SIZE);
        }
    }

    private int currentAnswerSize() {
        return this.balls.size();
    }

    public Ball getBallByPosition(BallPosition ballPosition) {
        int position = ballPosition.value() - 1;
        return balls.get(position);
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
