package baseball.domain.randomnumber;

import baseball.domain.CountResult;
import baseball.domain.SingleNumberUtils;
import baseball.domain.SingleNumber;
import baseball.domain.inputnumber.InputNumbers;

import java.util.List;

import static baseball.domain.randomnumber.RandomNumberGenerator.*;

public class RandomNumbers {

    private final List<SingleNumber> randomNumbers;

    public RandomNumbers() {
        this(SingleNumberUtils.singleNumberList(randomNumber()));
    }

    private RandomNumbers(List<SingleNumber> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public CountResult ballAndStrikeCount(InputNumbers inputNumbers) {
        int ballCount = inputNumbers.ballCount(randomNumbers);
        int strikeCount = inputNumbers.strikeCount(randomNumbers);

        return new CountResult(ballCount, strikeCount);
    }

    /**
     * 테스트용 메서드 입니다.
     */
    int size() {
        return randomNumbers.size();
    }

    /**
     * 테스트용 메서드 입니다.
     */
    boolean isDuplicated() {
        int count = (int) randomNumbers.stream()
                .distinct()
                .count();
        return count != 3;
    }
}
