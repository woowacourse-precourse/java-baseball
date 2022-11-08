package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class BallCollection {
    public static final int BALL_COUNT = 3;

    private List<Integer> balls;

    public BallCollection(List<Integer> balls) {
        validateBalls(balls);
        this.balls = balls;
    }

    public static BallCollection createComputerNumbers() {
        List<Integer> balls = new ArrayList<>();

        while (balls.size() < BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }

        return new BallCollection(balls);
    }

    private void validateBalls(List<Integer> balls) {
        Set<Integer> uniqueNumbers = new HashSet<>(balls);

        if (uniqueNumbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }

    public static BallCollection stringToBallCollection(String numbers) {
        List<Integer> balls = Arrays.stream(numbers.split(""))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        return new BallCollection(balls);
    }

    public int size() {
        return this.balls.size();
    }
}
