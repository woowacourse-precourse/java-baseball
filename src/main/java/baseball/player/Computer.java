package baseball.player;

import baseball.system.constant.BaseballConstant;
import baseball.utils.*;

import java.util.List;


public class Computer {
    private List<Integer> computerNumbers;

    public Computer() {
        this.computerNumbers = createNonDuplicationRandomThreeNumbers(BaseballConstant.NUMBERS_COUNT,
                BaseballConstant.MIN_NUMBER,BaseballConstant.MAX_NUMBER);
    }

    private List<Integer> createNonDuplicationRandomThreeNumbers(int numbersCount,int minNumber,int maxNumber) {
        List<Integer> numbers;

        for (; ; ) {

            numbers = NumberParsingCollection.createRandomNumbersInRange(numbersCount, minNumber, maxNumber);

            if (isNotDuplication(numbers)) {
                return numbers;
            }
        }
    }

    private boolean isNotDuplication(List<Integer> numbers){
        return !IsCollection.isDuplication(numbers);
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
