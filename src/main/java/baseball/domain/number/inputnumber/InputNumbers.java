package baseball.domain.number.inputnumber;

import baseball.domain.number.SingleNumber;

import java.util.List;

public class InputNumbers {

    private final List<SingleNumber> inputNumbers;

    InputNumbers(List<SingleNumber> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public int countBall(List<SingleNumber> randomNumbers) {
        int ballCount = 0;
        for (SingleNumber inputNumber : inputNumbers) {
            ballCount += inputNumber.judgeBall(randomNumbers);
        }

        return ballCount;
    }

    public int countStrike(List<SingleNumber> randomNumbers) {
        int strikeCount = 0;
        for (SingleNumber inputNumber : inputNumbers) {
            if (randomNumbers.contains(inputNumber)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
