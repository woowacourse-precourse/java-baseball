package baseball.game.number;

import java.util.List;
import java.util.Objects;

public class GameNumber {
    public final Digit first;
    public final Digit second;
    public final Digit third;
    public static final int FULL_SIZE = 3;
    private static final int FIRST_IDX = 0;
    private static final int SECOND_IDX = 1;
    private static final int THIRD_IDX = 2;

    public GameNumber(List<Integer> digits) {
        this.first = new Digit(digits.get(FIRST_IDX));
        this.second = new Digit(digits.get(SECOND_IDX));
        this.third = new Digit(digits.get(THIRD_IDX));
    }

    public static GameNumber of(int num) {
        validateNumber(num);
        return new GameNumber(separateToDigits(num));
    }

    private static void validateNumber(int num) {
        isInputValidRange(num);
        areInputDigitsUnique(num);
    }

    public static GameNumber of(String numberString) {
        int number = convertToIntOrThrow(numberString);
        validateNumber(number);
        return new GameNumber(separateToDigits(number));
    }

    private static int convertToIntOrThrow(String numberString) {
        int number;
        try {
            number = Integer.parseInt(numberString);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        return number;
    }

    public boolean contains(Digit digit) {
        return first.equals(digit) || second.equals(digit) || third.equals(digit);
    }

    private static List<Integer> separateToDigits(int num) {
        Integer firstDigit = num / 100;
        Integer secondDigit = (num % 100) / 10;
        Integer thirdDigit = num % 10;
        return List.of(firstDigit, secondDigit, thirdDigit);
    }

    private static void isInputValidRange(int num) {
        if (100 <= num && num < 1000) {
            return;
        }
        throw new IllegalArgumentException("3자리 수가 아닙니다.");
    }

    private static void areInputDigitsUnique(int num) {
        List<Integer> digits = separateToDigits(num);
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
        GameNumber number = (GameNumber) o;
        return Objects.equals(first, number.first) && Objects.equals(second, number.second)
                && Objects.equals(third, number.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
