package baseball.domain.number.randomnumber;

import baseball.domain.count.CountResult;
import baseball.domain.count.ball.BallCounter;
import baseball.domain.count.strike.StrikeCounter;
import baseball.domain.number.SingleNumber;
import baseball.domain.number.inputnumber.InputNumbers;

import java.util.List;
// 인터페이스
public class RandomNumbers {

    private final List<SingleNumber> randomNumbers;  // 컴퓨터 숫자
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
     */
    public int size() {
        return randomNumbers.size();
    }

    public int countSingleNumbers() {
        return (int) randomNumbers.stream()
                .distinct()
                .count();
    }

}
