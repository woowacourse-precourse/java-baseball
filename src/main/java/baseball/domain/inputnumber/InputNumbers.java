package baseball.domain.inputnumber;

import baseball.domain.SingleNumber;

import java.util.List;

public class InputNumbers {

    private final List<SingleNumber> inputNumbers;

    InputNumbers(List<SingleNumber> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public int ballCount(List<SingleNumber> randomNumbers) {
        int ballCount = 0;
        for (SingleNumber inputNumber : inputNumbers) {
            ballCount += inputNumber.judgementOnBall(randomNumbers);
        }

        return ballCount;
    }

    public int strikeCount(List<SingleNumber> randomNumbers) {
        int strikeCount = 0;
        for (SingleNumber inputNumber : inputNumbers) {
            if (randomNumbers.contains(inputNumber)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
