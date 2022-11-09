package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hitter {
    private static final int NUMBER_OF_BALLS = 3;
    private static final String INVALID_NUMBER_RANGE_REGEX = "[^1-9]";

    public Balls hitBalls(String number) {
        return new Balls(IntStream.range(0, number.length())
                .mapToObj(index ->
                        new Ball(Character.getNumericValue(number.charAt(index)), index))
                .collect(Collectors.toList()));
    }

    private void validate(String number) {
        validateNumberLength(number);
        validateNumberRange(number);
        validateNumberDuplication(number);
    }

    public String inputNumber() {
        System.out.print(BaseballMessage.INPUT_NUMBER_MESSAGE.getMessage());
        String number = Console.readLine();
        validate(number);
        return number;
    }

    private void validateNumberLength(String number) {
        if (number.length() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException(NUMBER_OF_BALLS + BaseballMessage.INVALID_NUMBER_LENGTH_MESSAGE.getMessage());
        }
    }

    private void validateNumberRange(String number) {
        if (Pattern.compile(INVALID_NUMBER_RANGE_REGEX).matcher(number).find()) {
            throw new IllegalArgumentException(BaseballMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    private void validateNumberDuplication(String number) {
        if (IntStream.range(0, 10)
                .anyMatch(digit -> isDuplicated(number, digit))) {
            throw new IllegalArgumentException(BaseballMessage.DUPLICATED_NUMBER_MESSAGE.getMessage());
        }
    }

    private boolean isDuplicated(String number, int digit) {
        return getDigitCount(number, digit) >= 2;
    }

    private long getDigitCount(String number, int digit) {
        return Arrays.stream(number.split(""))
                .filter(digitString -> digitString.equals(String.valueOf(digit)))
                .count();
    }
}
