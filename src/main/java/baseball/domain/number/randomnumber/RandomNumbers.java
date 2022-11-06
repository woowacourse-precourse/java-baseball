package baseball.domain.number.randomnumber;

import baseball.domain.count.CountResult;
import baseball.domain.count.ball.BallCounter;
import baseball.domain.count.strike.StrikeCounter;
import baseball.domain.number.SingleNumber;
import baseball.domain.number.inputnumber.InputNumbers;

import java.util.List;

public class RandomNumbers {

    private final List<SingleNumber> randomNumbers;
    private final BallCounter ballCounter;
    private final StrikeCounter strikeCounter;

    public RandomNumbers(List<SingleNumber> randomNumbers,
                         BallCounter ballCounter, StrikeCounter strikeCounter) {
        this.randomNumbers = randomNumbers;
        this.ballCounter = ballCounter;
        this.strikeCounter = strikeCounter;
    }

    public CountResult countBallAndStrike(InputNumbers inputNumbers) {
        List<SingleNumber> inputNumberList = inputNumbers.inputNumbers();
        int ballCount = ballCounter.checkBall(randomNumbers, inputNumberList);
        int strikeCount = strikeCounter.checkStrike(randomNumbers, inputNumberList);

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
