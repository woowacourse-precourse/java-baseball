package baseball;

import javax.xml.validation.Validator;

public class Ball {

    public static final int BEGIN = 1;
    public static final int END = 9;
    private final int number;

    public Ball(int number) {
        this.number = number;
        validate(number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if(number >= BEGIN && number <= END) {
            return;
        }
        throw new IllegalArgumentException("유효한 숫자 범위가 아닙니다.")
    }
}
