package baseball.player;

import baseball.system.BaseballConstant;
import baseball.utils.*;

import java.util.ArrayList;
import java.util.List;


public class Computer {
    private List<Integer> computerNumbers;

    public Computer() {
        this.computerNumbers = createNonDuplicationRandomThreeNumbers();
    }

    private List<Integer> createNonDuplicationRandomThreeNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (; ; ) {

            numbers = NumberParsingCollection.createRandomNumbersInRange(
                    numbers,
                    BaseballConstant.NUMBERS_COUNT,
                    BaseballConstant.MIN_NUMBER,
                    BaseballConstant.MAX_NUMBER);

            if (!IsCollection.isDuplication(numbers)) {
                return numbers;
            }
        }
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
