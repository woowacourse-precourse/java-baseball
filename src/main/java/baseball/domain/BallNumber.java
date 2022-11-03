package baseball.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BallNumber {
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "잘못된 입력입니다. (1~9 범위의 3개 숫자만 입력 가능)";
    private static final String NUMBER_FORMAT = "[1-9]";
    
    private final int number;
    
    public BallNumber(final String number) {
        this(parseCorrectNumber(number));
    }
    
    public BallNumber(final int number) {
        this.number = number;
    }
    
    private static int parseCorrectNumber(final String number) {
        validateNumberForm(number);
        return Integer.parseInt(number);
    }
    
    private static void validateNumberForm(final String number) {
        final Pattern pattern = Pattern.compile(NUMBER_FORMAT);
        final Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BallNumber that = (BallNumber) o;
        return number == that.number;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
