package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

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
}
