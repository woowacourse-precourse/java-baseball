package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameModel {
    private static final int MAX_NUMBER_SIZE = 3;

    private List<Integer> computerNumbers = new ArrayList<>();
    private boolean isFinish;

    public int ballCount(List<Integer> userNumbers) {
        int ball = 0;

        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            if (computerNumbers.contains(userNumbers.get(i))
                    && computerNumbers.get(i) != userNumbers.get(i))
                ball++;
        }

        return ball;
    }

    public int strikeCount(List<Integer> userNumbers) {
        int strike = 0;

        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            if (computerNumbers.get(i) == userNumbers.get(i))
                strike++;
        }

        if (strike == MAX_NUMBER_SIZE)
            isFinish = true;

        return strike;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void createRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();
        isFinish = false;

        computerNumbers = randomNumber.initialize(MAX_NUMBER_SIZE);
    }
}
