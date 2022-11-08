package domain;

import java.util.HashSet;
import java.util.List;

public class Number {
    private final List<Integer> number;

    public Number(List<Integer> number) {
        this.number = number;
        validateThreeDigitNumber();
        validateNaturalNumber();
        validateDifferentNumber();
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

    public void validateDifferentNumber() {
        HashSet<Integer> compareDigits = new HashSet<>();

        for (int digit = 0; digit < 3; digit++) {
            if (!(compareDigits.add(number.get(digit)))) {
                throw new IllegalArgumentException("각 자리 수는 서로 다른 숫자여야 합니다.");
            }
        }
    }

    public int getDigit(int digit) {
        return number.get(digit);
    }
}
