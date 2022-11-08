package baseball.game.number;

import java.util.List;
import java.util.Objects;

public class Number {
    public final Digit first;
    public final Digit second;
    public final Digit third;
    public static final int FULL_SIZE = 3;
    private final int FIRST_IDX = 0;
    private final int SECOND_IDX = 1;
    private final int THIRD_IDX = 2;

    public Number(List<Integer> digits) {
        this.first = new Digit(digits.get(FIRST_IDX));
        this.second = new Digit(digits.get(SECOND_IDX));
        this.third = new Digit(digits.get(THIRD_IDX));
    }

    public Number(int num) {
        isInputValidRange(num);

        List<Integer> separatedDigits = separateToDigits(num);
        areInputDigitsUnique(separatedDigits);

        first = new Digit(separatedDigits.get(FIRST_IDX));
        second = new Digit(separatedDigits.get(SECOND_IDX));
        third = new Digit(separatedDigits.get(THIRD_IDX));
    }

    public boolean contains(Digit digit) {
        return first.equals(digit) || second.equals(digit) || third.equals(digit);
    }

    private List<Integer> separateToDigits(int num) {
        Integer firstDigit = num / 100;
        Integer secondDigit = (num % 100) / 10;
        Integer thirdDigit = num % 10;
        return List.of(firstDigit, secondDigit, thirdDigit);
    }

    private void isInputValidRange(int num) {
        if (100 <= num && num < 1000) {
            return;
        }
        throw new IllegalArgumentException("3자리 수가 아닙니다.");
    }

    private void areInputDigitsUnique(List<Integer> digits) {
        int first = digits.get(FIRST_IDX);
        int second = digits.get(SECOND_IDX);
        int third = digits.get(THIRD_IDX);
        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException("서로 다른 3자리 수가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return Objects.equals(first, number.first) && Objects.equals(second, number.second)
                && Objects.equals(third, number.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
