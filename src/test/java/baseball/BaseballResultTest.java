package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballResultTest {
    @Test
    void 선택한_숫자가_올_스트라이크() {
        List<Integer> answerNumbers = new ArrayList<>();
        for (int count = 1; count <= BaseballNumber.NUMBER_COUNT; count++) {
            answerNumbers.add(BaseballNumber.MIN_NUMBER + count - 1);
        }
        BaseballNumber computerNumbers = new BaseballNumber(answerNumbers);
        BaseballNumber userNumbers = new BaseballNumber(answerNumbers);

        BaseballResult baseballResult = new BaseballResult();

        BaseballScore result = baseballResult.getBaseballScore(computerNumbers, userNumbers);
        BaseballScore expected = new BaseballScore(3, 0);

        assertEquals(result.get_strikes(), expected.get_strikes());
        assertEquals(result.get_balls(), expected.get_balls());
    }

    @Test
    void 선택한_숫자가_낫씽() {

        List<Integer> answerNumbers = new ArrayList<>();
        for (int count = 1; count <= BaseballNumber.NUMBER_COUNT; count++) {
            answerNumbers.add(BaseballNumber.MIN_NUMBER + count - 1);
        }
        BaseballNumber computerNumbers = new BaseballNumber(answerNumbers);

        List<Integer> numbers = new ArrayList<>();

        int maxComputerNumber = answerNumbers.get(BaseballNumber.NUMBER_COUNT - 1);
        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            numbers.add(maxComputerNumber + index + 1);
        }
        BaseballNumber userNumbers = new BaseballNumber(numbers);

        BaseballResult baseballResult = new BaseballResult();

        BaseballScore result = baseballResult.getBaseballScore(computerNumbers, userNumbers);
        BaseballScore expected = new BaseballScore(0, 0);
        assertEquals(result.get_strikes(), expected.get_strikes());
        assertEquals(result.get_balls(), expected.get_balls());
    }


    @Test
    void 선택한_숫자가_2스트라이크() {

        List<Integer> answerNumbers = new ArrayList<>();
        for (int count = 1; count <= BaseballNumber.NUMBER_COUNT; count++) {
            answerNumbers.add(BaseballNumber.MIN_NUMBER + count - 1);
        }
        BaseballNumber computerNumbers = new BaseballNumber(answerNumbers);

        List<Integer> numbers = new ArrayList<>();
        int lastIndex = BaseballNumber.NUMBER_COUNT - 1;
        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            if (index == lastIndex) {
                numbers.add(BaseballNumber.MAX_NUMBER);
                break;
            }
            numbers.add(answerNumbers.get(index));
        }
        BaseballNumber userNumbers = new BaseballNumber(numbers);

        BaseballResult baseballResult = new BaseballResult();

        BaseballScore result = baseballResult.getBaseballScore(computerNumbers, userNumbers);
        BaseballScore expected = new BaseballScore(2, 0);
        assertEquals(result.get_strikes(), expected.get_strikes());
        assertEquals(result.get_balls(), expected.get_balls());
    }

    @Test
    void 선택한_숫자가_2볼() {

        List<Integer> answerNumbers = new ArrayList<>();
        for (int count = 1; count <= BaseballNumber.NUMBER_COUNT; count++) {
            answerNumbers.add(BaseballNumber.MIN_NUMBER + count - 1);
        }
        BaseballNumber computerNumbers = new BaseballNumber(answerNumbers);

        List<Integer> numbers = new ArrayList<>();
        int lastIndex = BaseballNumber.NUMBER_COUNT - 1;
        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            if (index == 0) {
                numbers.add(BaseballNumber.MAX_NUMBER);
                continue;
            }
            numbers.add(answerNumbers.get(lastIndex - index + 1));
        }
        BaseballNumber userNumbers = new BaseballNumber(numbers);

        BaseballResult baseballResult = new BaseballResult();

        BaseballScore result = baseballResult.getBaseballScore(computerNumbers, userNumbers);
        BaseballScore expected = new BaseballScore(0, 2);
        assertEquals(result.get_strikes(), expected.get_strikes());
        assertEquals(result.get_balls(), expected.get_balls());
    }

    @Test
    void 선택한_숫자가_1스트라이크_2볼() {

        List<Integer> answerNumbers = new ArrayList<>();
        for (int count = 1; count <= BaseballNumber.NUMBER_COUNT; count++) {
            answerNumbers.add(BaseballNumber.MIN_NUMBER + count - 1);
        }
        BaseballNumber computerNumbers = new BaseballNumber(answerNumbers);

        List<Integer> numbers = new ArrayList<>();
        int lastIndex = BaseballNumber.NUMBER_COUNT - 1;
        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            if (index == 0) {
                numbers.add(answerNumbers.get(index));
                continue;
            }
            numbers.add(answerNumbers.get(lastIndex - index + 1));
        }
        BaseballNumber userNumbers = new BaseballNumber(numbers);

        BaseballResult baseballResult = new BaseballResult();

        BaseballScore result = baseballResult.getBaseballScore(computerNumbers, userNumbers);
        BaseballScore expected = new BaseballScore(1, 2);
        assertEquals(result.get_strikes(), expected.get_strikes());
        assertEquals(result.get_balls(), expected.get_balls());
    }

}
