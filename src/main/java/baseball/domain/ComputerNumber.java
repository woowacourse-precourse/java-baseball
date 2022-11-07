package baseball.domain;

import java.util.List;

public class ComputerNumber {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public ComputerNumber(List<Integer> numberList) {
        this.firstNumber = numberList.get(FIRST);
        this.secondNumber = numberList.get(SECOND);
        this.thirdNumber = numberList.get(THIRD);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }
}
