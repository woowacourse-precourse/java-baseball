package baseball.player;

import baseball.system.constant.BaseballConstant;
import baseball.utils.*;

import java.util.List;


public class Computer {
    private List<Integer> computerNumbers;

    public Computer() {
        this.computerNumbers = createNonDuplicationRandomThreeNumbers();
    }

    private List<Integer> createNonDuplicationRandomThreeNumbers() {
        List<Integer> numbers;

        final int MIN_NUMBER = BaseballConstant.MIN_NUMBER;
        final int MAX_NUMBER = BaseballConstant.MAX_NUMBER;
        final int NUMBERS_COUNT = BaseballConstant.NUMBERS_COUNT;

        for (; ; ) {

            numbers = NumberParsingCollection.createRandomNumbersInRange(NUMBERS_COUNT, MIN_NUMBER, MAX_NUMBER);

            if (!IsCollection.isDuplication(numbers)) {
                return numbers;
            }
        }
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
