package baseball.core;

import java.util.List;

public class Computer {

    private List<Integer> randomNumbers;

    public Computer(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public BallStrike answer(List<Integer> threeNumbers) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            int number = threeNumbers.get(i);

            if (isStrike(i, number)) {
                strikeCount++;
            } else if (isBall(number)) {
                ballCount++;
            }
        }
        return new BallStrike(ballCount, strikeCount);
    }

    public void setNewAnswer(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    private boolean isStrike(int i, int number) {
        return randomNumbers.get(i).equals(number);
    }

    private boolean isBall(int number) {
        return randomNumbers.contains(number);
    }
}
