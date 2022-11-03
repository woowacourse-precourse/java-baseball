package domain;

import java.util.List;

public class Number {
    public final List<Integer> number;

    public Number(List<Integer> number) {
        this.number = number;
        validateThreeDigitNumber();
        validateNaturalNumber();
    }

    public void validateThreeDigitNumber() {
        if (number.size() != 3) {
            throw new IllegalArgumentException("숫자는 세 자리 자연수여야 합니다.");
        }
    }

    public void validateNaturalNumber() {
        for (Integer digit : number) {
            if (digit <= 0) {
                throw new IllegalArgumentException("각 자리 수는 0이 아닌 자연수여야 합니다.");
            }
        }
    }
}
