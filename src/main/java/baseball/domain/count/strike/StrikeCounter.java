package baseball.domain.count.strike;

import baseball.domain.number.SingleNumber;

import java.util.List;

public class StrikeCounter {

    public StrikeResult checkStrike(List<SingleNumber> randomNumbers, List<SingleNumber> inputNumbers) {
        int strikeCount = 0;
        for (SingleNumber inputNumber : inputNumbers) {
            if (randomNumbers.contains(inputNumber)) {
                strikeCount++;
            }
        }

        return new StrikeResult(strikeCount);
    }
}
