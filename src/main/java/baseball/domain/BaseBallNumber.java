package baseball.domain;

public class BaseBallNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int inputValue;

    public BaseBallNumber(int inputValue) {
        vaildateNumber(inputValue);
        this.inputValue = inputValue;
    }

    private void vaildateNumber(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자의 입력 범위를 초과하였습니다.");
        }
    }

}
