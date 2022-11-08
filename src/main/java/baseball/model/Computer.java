package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public Balls generateRandomBalls(int maxSize, int minBallNumber, int maxBallNumber) {
        Balls computerBalls = new Balls();

        while (!computerBalls.isSize(maxSize)) {
            computerBalls.addBall(new Ball(Randoms.pickNumberInRange(minBallNumber, maxBallNumber)));
        }
        return computerBalls;
    }
}