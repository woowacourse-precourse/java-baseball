package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    public Balls generateRandomBalls(int maxSize, int minBallNumber, int maxBallNumber) {
        Balls computerBalls = new Balls();

        while (!computerBalls.isSize(maxSize)) {
            computerBalls.addBall(Randoms.pickNumberInRange(minBallNumber, maxBallNumber));
        }
        return computerBalls;
    }
}