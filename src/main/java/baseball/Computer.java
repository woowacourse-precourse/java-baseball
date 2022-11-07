package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber = new ArrayList<>();
    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 9;
    private static final int BALL_COUNT = 3;

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void generateRandomNumber() {
        List<Integer> randomBallNumbers = new ArrayList<>();
        while (randomBallNumbers.size() < BALL_COUNT) {
            int ballNumber = Randoms.pickNumberInRange(MINIMUM_BALL_NUMBER, MAXIMUM_BALL_NUMBER);
            if (!randomBallNumbers.contains(ballNumber)) {
                randomBallNumbers.add(ballNumber);
            }
        }
        this.computerNumber = randomBallNumbers;
    }
}
