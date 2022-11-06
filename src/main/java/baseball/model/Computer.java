package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {

    public Balls generateRandomBalls() {
        Balls computerBalls = new Balls(new ArrayList<>());

        while (computerBalls.isSize(3)) {
            computerBalls.addBall(Randoms.pickNumberInRange(1, 9));
        }
        return computerBalls;
    }
}