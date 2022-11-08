package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {
    List<Ball> balls;

    public Computer() {
    }

    Computer(List<Ball> balls) {
        this.balls = balls;
    }

    public void init() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        balls = BallGenerator.getBalls(list);
    }

    public String getResult(List<Ball> assumtion) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Ball ball1 = balls.get(i);
                Ball ball2 = assumtion.get(j);
                if (ball1.getNumber() != ball2.getNumber()) continue;
                if (ball1.getPosition() != ball2.getPosition()) ball++;
                else strike++;
            }
        }
        if (strike == 0 && ball == 0) return "낫싱";
        else if (ball == 0) return strike+"스트라이크";
        else if (strike == 0) return ball+"볼";
        return ball+"볼 "+strike+"스트라이크";
    }
}
