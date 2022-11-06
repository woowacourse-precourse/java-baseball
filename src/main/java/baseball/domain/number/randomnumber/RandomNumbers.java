package baseball.domain.number.randomnumber;

import baseball.domain.count.CountResult;
import baseball.domain.number.SingleNumber;
import baseball.domain.number.inputnumber.InputNumbers;

import java.util.List;

public class RandomNumbers {

    private final List<SingleNumber> randomNumbers;

    public RandomNumbers(List<SingleNumber> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public CountResult countBallAndStrike(InputNumbers inputNumbers) {
        int ballCount = inputNumbers.countBall(randomNumbers);
        int strikeCount = inputNumbers.countStrike(randomNumbers);

        return new CountResult(ballCount, strikeCount);
    }

    /**
     * 테스트용 메서드 입니다.
     * size() : 리스트의 사이즈 반환
     * countSingleNumbers() : 중복 체크
     */
    public int size() {
        return randomNumbers.size();
    }

    public boolean isDuplicated() {
        int count = (int) randomNumbers.stream()
                .distinct()
                .count();
        return count != 3;
    }
}
