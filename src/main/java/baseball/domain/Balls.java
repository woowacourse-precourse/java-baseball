package baseball.domain;

import baseball.exception.NumberValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Balls {

    private final List<Integer> balls;

    private Balls(List<Integer> balls) {
        this.balls = balls;
    }

    public static Balls createBall(List<Integer> balls) {
        return new Balls(balls);
    }

    public static Balls valueOf(String number) {
        validateBall(number);
        List<Integer> list = Stream.of(number.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return new Balls(list);
    }

    private static void validateBall(String number) {
        NumberValidator.isDigits(number);
        NumberValidator.isPositiveDigits(number);
        NumberValidator.isThreeDigits(number);
        NumberValidator.isNotDuplicateDigits(number);
    }

    public List<Integer> asList() {
        return balls;
    }
}
