package domain;

import java.util.List;

public class Number {
    public final List<Integer> number;

    public Number(List<Integer> number) {
        this.number = number;
        validateThreeDigitNumber();
    }

    public void validateThreeDigitNumber() {
        if (number.size() != 3) {
            throw new IllegalArgumentException("숫자는 세 자리 자연수여야 합니다.");
        }
    }
}
