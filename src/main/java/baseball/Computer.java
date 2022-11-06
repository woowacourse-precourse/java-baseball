package baseball;

import java.util.List;

import static baseball.Constant.*;

public class Computer {
    private BaseballNumber answer;

    public void putAnswer() {
        List<Integer> numbers = makeNotDuplicatedRandomNumbers();
        this.answer = new BaseballNumber(numbers);
        System.out.println("(임시) 숫자야구의 정답 : " + answer); // TODO: 마지막에 삭제
    }

    protected List<Integer> makeNotDuplicatedRandomNumbers() {
        return RandomGenerator.makeNotDuplicatedRandomNumbers(NUMBER_CNT, MIN_RANGE, MAX_RANGE);
    }

    public List<Integer> returnResult(BaseballNumber guessNumber) { // TODO 고민 Point : 반환타입 List가 맞을까, []가 맞을까
        if (answer == null) {
            throw new IllegalStateException("Computer에 정답이 저장되어 있지 않습니다");
        }
        return guessNumber.match(answer);
    }

}
