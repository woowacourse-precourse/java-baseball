package baseball.game;

import java.util.List;
import java.util.Objects;

public class Number {
    public final int first;
    public final int second;
    public final int third;

    public Number(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Number(int num) {
        List<Integer> separatedDigits = separateToDigits(num);
        first = separatedDigits.get(0);
        second = separatedDigits.get(1);
        third = separatedDigits.get(2);
    }

    public boolean hasDigit(int digit) {
        return digit == first || digit == second || digit == third;
    }

    protected List<Integer> separateToDigits(int num) {
        Integer firstDigit = num / 100;
        Integer secondDigit = (num % 100) / 10;
        Integer thirdDigit = num % 10;
        return List.of(firstDigit, secondDigit, thirdDigit);
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
        return first == number.first && second == number.second && third == number.third;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
