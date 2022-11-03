package domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    public final List<Integer> number;

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
        List<Integer> compareDigits = new ArrayList<>();
        compareDigits.addAll(number);

        for (int digit = 0; digit < this.number.size(); digit++) {
            compareDigits.remove(number.get(digit));
            if (compareDigits.contains(digit)) {
                throw new IllegalArgumentException("각 자리 수는 서로 다른 숫자여야 합니다.");
            }
        }
    }
}
