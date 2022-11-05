package baseball;

import org.mockito.exceptions.misusing.WrongTypeOfReturnValue;

import java.util.ArrayList;
import java.util.List;
import static baseball.Const.SIZE;
import static baseball.Const.WRONG_INPUT;

public class Balls {
    private List<Ball> ballList;

    public Balls() {
        this.ballList = new ArrayList<>();
    }

    public void addBall(Ball ball) {
        this.ballList.add(ball);
    }

    public boolean checkDuplicate(Ball ball) {
        return ballList.contains(ball);
    }

    public void generate() {
        while (this.ballList.size() != SIZE) {
            Ball ball = new Ball();
            ball.generate();

            if (!checkDuplicate(ball)) {
                ballList.add(ball);
            }
        }
    }

    public List<Ball> getBallList() {
        return this.ballList;
    }

    public void convertInputToBall(String input) throws IllegalArgumentException {
        // 반복문으로 한글자씩 때어보면서 ball 로 만드는데, 이미 ball 로 만들때 잘못된 경우라면 예외를 반환하니깐 그냥 순서대로 담으면 된다.
        if (input.length() != SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }

        for (int i = 0; i < SIZE; i++) {
            Ball additionalBall = new Ball(input.charAt(i));
            ballList.add(additionalBall);
        }
    }
}
