package baseball.domain;

import static baseball.domain.Ball.MAX_RANGE;
import static baseball.domain.Ball.MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private static final int BALL_SIZE = 3;
    private static final String SIZE_EXCEPTION_MESSAGE = "3자리 숫자를 입력해주세요";
    private static final String UNIQUE_EXCEPTION_MESSAGE = "중복된 숫자는 입력할 수 없습니다";

    private List<Ball> balls;

    private Balls(List<Ball> balls) {
        validateUnique(balls);
        validateSize(balls);
        this.balls = balls;
    }

    private void validateSize(List<Ball> balls) {
        if (balls.size() != BALL_SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validateUnique(List<Ball> balls) {
        int count = (int) balls.stream()
                .distinct()
                .count();
        if (count != balls.size()) {
            throw new IllegalArgumentException(UNIQUE_EXCEPTION_MESSAGE);
        }
    }

    public static Balls generateUniqueBalls() {
        List<Ball> uniqueBalls = new ArrayList<>();
        while (uniqueBalls.size() < BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            Ball randomBall = new Ball(randomNumber);

            if (!uniqueBalls.contains(randomBall)) {
                uniqueBalls.add(randomBall);
            }
        }
        return new Balls(uniqueBalls);
    }

    public static Balls convertNumberToBalls(List<Integer> inputNumber) {
        List<Ball> balls = inputNumber.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
        return new Balls(balls);
    }

    public int equalsExactly(Balls player) {
        int count = 0;
        for (int position = 0; position < BALL_SIZE; position++) {
            if (isBallEqual(player, position)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBallEqual(Balls player, int index) {
        return getBall(index).equals(player.getBall(index));
    }

    private Ball getBall(int index) {
        return balls.get(index);
    }

    public int containsCountWithoutEqual(Balls player) {
        int count = 0;
        for (int position = 0; position < BALL_SIZE; position++) {
            if (balls.contains(player.getBall(position)) && !isBallEqual(player, position)) {
                count++;
            }
        }
        return count;
    }
}
