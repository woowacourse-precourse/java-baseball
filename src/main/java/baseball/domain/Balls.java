package baseball.domain;

import baseball.exception.NumberExceptionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Balls {

    private final List<Integer> balls;

    public Balls(List<Integer> balls) {
        this.balls = balls;
    }

    public static Balls valueOf(String number) {
        validateBall(number);
        List<Integer> list = Stream.of(number.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return new Balls(list);
    }

    public static void validateBall(String number) {
        NumberExceptionUtils.isDigit(number);
        NumberExceptionUtils.isPositiveDigits(number);
        NumberExceptionUtils.isThreeDigits(number);
        NumberExceptionUtils.isNotDuplicateNumber(number);
    }

    public List<Integer> asList() {
        return new ArrayList<>(balls);
    }
}
