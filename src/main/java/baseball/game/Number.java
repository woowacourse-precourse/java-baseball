package baseball.game;

import java.util.List;
import java.util.Objects;

public class Number {
    public final Digit first;
    public final Digit second;
    public final Digit third;

    public Number(List<Integer> digits) {
        this.first = new Digit(digits.get(0));
        this.second = new Digit(digits.get(1));
        this.third = new Digit(digits.get(2));
    }

    public Number(int num) {
        List<Integer> separatedDigits = separateToDigits(num);
        first = new Digit(separatedDigits.get(0));
        second = new Digit(separatedDigits.get(1));
        third = new Digit(separatedDigits.get(2));
    }

    public boolean contains(Digit digit) {
        return first.equals(digit) || second.equals(digit) || third.equals(digit);
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
