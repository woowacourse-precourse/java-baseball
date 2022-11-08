package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer extends Player {

    @Override
    public void selectBalls() {
        while (getBallsNumber() < 3) {
            String ball = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!isSelectBall(ball)) {
                selectBall(ball);
            }
        }
    }
}
