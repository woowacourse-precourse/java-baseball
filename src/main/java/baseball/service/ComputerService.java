package baseball.service;

import baseball.model.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    public List<Ball> generateRandomBalls() {
        List<Ball> computerBalls = new ArrayList<>();

        while (computerBalls.size() < 3) {
            Ball computerBall = new Ball(Randoms.pickNumberInRange(1, 9));
            if (computerBalls.contains(computerBall)) {
                continue;
            }
            computerBalls.add(computerBall);
        }

        return computerBalls;
    }
}
