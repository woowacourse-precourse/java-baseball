package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameModel {
    private static final int MAX_NUMBER_SIZE = 3;

    private List<Integer> computerNumbers = new ArrayList<>();
    private boolean isFinish;

    public int countBalls(List<Integer> userNumbers) {
        int ball = 0;

        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumbers.contains(userNumber)
                    && computerNumber != userNumber)
                ball++;
        }

        return ball;
    }

    public int countStrikes(List<Integer> userNumbers) {
        int strike = 0;

        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumber == userNumber)
                strike++;
        }

        if (strike == MAX_NUMBER_SIZE)
            isFinish = true;

        return strike;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void initialize() {
        RandomNumber randomNumber = new RandomNumber();
        isFinish = false;

        computerNumbers = randomNumber.createNumbers(MAX_NUMBER_SIZE);
    }
}
