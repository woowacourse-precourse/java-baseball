package baseball.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ball {
    private static final String BALL_SIZE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 ball의 크기 입니다.";
    private static final String REDUPLICATION_ERROR_MESSAGE = "[ERROR] ball의 데이터는 중복을 허용하지 않습니다.";
    private List<Integer> ballData;
    private int ballSize = 3;

    public Ball() {
    }

    public Ball(List<Integer> ball) {
        ballValidation(ball);
        this.ballData = new ArrayList<>(ball);
    }

    public List<Integer> getBallData() {
        return new ArrayList<>(ballData);
    }

    private void ballValidation(List<Integer> ball) {
        lengthValidation(ball);
        reduplicationValidation(ball);
    }

    private void lengthValidation(List<Integer> ball) {
        if (ball.size() != ballSize) {
            throw new IllegalArgumentException(BALL_SIZE_ERROR_MESSAGE);
        }
    }

    private void reduplicationValidation(List<Integer> ball) {
        long unReduplicationData = ball.stream().distinct().count();
        if (ball.size() != unReduplicationData) {
            throw new IllegalArgumentException(REDUPLICATION_ERROR_MESSAGE);
        }
    }
}
