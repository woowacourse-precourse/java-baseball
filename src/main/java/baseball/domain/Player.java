package baseball.domain;

import baseball.exception.NumberExceptionUtils;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Player {

    private List<Integer> balls;

    public void setInputBall() {
        String input = Console.readLine();
        validateBall(input);
        balls = mapStringToIntegerList(input);
    }

    public List<Integer> getBall() {
        return new ArrayList<>(balls);
    }

    private void validateBall(String number) {
        NumberExceptionUtils.isDigit(number);
        NumberExceptionUtils.isPositiveDigits(number);
        NumberExceptionUtils.isThreeDigits(number);
        NumberExceptionUtils.isNotDuplicateNumber(number);
    }

    private static List<Integer> mapStringToIntegerList(String input) {
        return Stream.of(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
