package baseball.domain;

import baseball.RandomGenerator;

import java.util.List;

import static baseball.Constant.*;

public class Computer {
    private BaseballNumber answer;

    public void makeAnswer() {
        List<Integer> numbers = makeNotDuplicatedRandomNumbers();
        this.answer = new BaseballNumber(numbers);
    }

    protected List<Integer> makeNotDuplicatedRandomNumbers() {
        return RandomGenerator.makeNotDuplicatedRandomNumbers(NUMBER_CNT, MIN_RANGE, MAX_RANGE);
    }

    public Result returnResult(BaseballNumber guessNumber) {
        if (answer == null) {
            throw new IllegalStateException("Computer에 정답이 저장되어 있지 않습니다");
        }
        return guessNumber.match(answer);
    }

}
