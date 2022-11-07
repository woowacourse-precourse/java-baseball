package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    //TODO 더 좋은 네이밍 생각해보기
    public static Balls generateUniqueBalls() {
        List<Ball> uniqueBalls = new ArrayList<>();
        while (uniqueBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
}
