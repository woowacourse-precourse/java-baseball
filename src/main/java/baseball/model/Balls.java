package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Integer> balls = new ArrayList<>();

    public Balls() {
        initBalls();
    }

    public Balls(List<Integer> balls) {
        this.balls.addAll(balls);
    }

    public void initBalls() {
        balls.clear();
        while (balls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }
    }

    public boolean isBall(int idx, int num) {
        return balls.get(idx) != num && balls.contains(num);
    }

    public boolean isStrike(int idx, int num) {
        return balls.get(idx) == num;
    }
}
