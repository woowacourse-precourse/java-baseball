package baseball.core.opponent;

import baseball.core.dto.BallStrikeDto;

import java.util.List;

public class ComputerOpponent {

    private List<Integer> randomNumbers;

    public ComputerOpponent(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public BallStrikeDto answer(List<Integer> threeNumbers) {
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
        return new BallStrikeDto(ballCount, strikeCount);
    }

    private boolean isStrike(int i, int number) {
        return randomNumbers.get(i).equals(number);
    }

    private boolean isBall(int number) {
        return randomNumbers.contains(number);
    }
}
