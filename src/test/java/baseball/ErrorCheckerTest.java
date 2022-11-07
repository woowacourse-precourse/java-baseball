package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorCheckerTest {

    private static final String DUPLICATE_NUMBER = "중복된 숫자가 포함되어있습니다.";
    private static final String ILLEGAL_INPUT = "잘못된 값이 입력되었습니다.";
    private static final String ILLEGAL_SIZE = "입력값이 정해진 자릿수가 아닙니다.";

    @Test
    void checkUserNumberError_메서드로_중복되지_않은_숫자_테스트() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        List<Integer> continueGameInputList = List.of(1, 2);

        ErrorChecker errorChecker = new ErrorChecker(numberSize, startInclusive, endInclusive, continueGameInputList);

        String input = "123";

        Assertions.assertThatCode(() -> errorChecker.checkUserNumberError(input))
                .doesNotThrowAnyException();
    }

    @Test
    void checkUserNumberError_메서드로_중복된_숫자_판별_테스트() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        List<Integer> continueGameInputList = List.of(1, 2);

        ErrorChecker errorChecker = new ErrorChecker(numberSize, startInclusive, endInclusive, continueGameInputList);

        String input = "112";

        assertThatThrownBy(() -> errorChecker.checkUserNumberError(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkUserNumberError_메서드로_중복된_숫자_예외_메시지_테스트() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        List<Integer> continueGameInputList = List.of(1, 2);

        ErrorChecker errorChecker = new ErrorChecker(numberSize, startInclusive, endInclusive, continueGameInputList);

        String input = "112";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> errorChecker.checkUserNumberError(input));

        assertEquals(exception.getMessage(), DUPLICATE_NUMBER);
    }

    @Test
    void checkUserNumberError_메서드로_정상적인_자릿수_값_입력_테스트() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        List<Integer> continueGameInputList = List.of(1, 2);

        ErrorChecker errorChecker = new ErrorChecker(numberSize, startInclusive, endInclusive, continueGameInputList);

        String input = "456";

        Assertions.assertThatCode(() -> errorChecker.checkUserNumberError(input))
                .doesNotThrowAnyException();
    }

    @Test
    void checkUserNumberError_메서드로_잘못된_자릿수_판별_테스트() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        List<Integer> continueGameInputList = List.of(1, 2);

        ErrorChecker errorChecker = new ErrorChecker(numberSize, startInclusive, endInclusive, continueGameInputList);

        String input = "1122";

        assertThatThrownBy(() -> errorChecker.checkUserNumberError(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkUserNumberError_메서드로_잘못된_자릿수_예외_메시지_테스트() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        List<Integer> continueGameInputList = List.of(1, 2);

        ErrorChecker errorChecker = new ErrorChecker(numberSize, startInclusive, endInclusive, continueGameInputList);

        String input = "1122";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> errorChecker.checkUserNumberError(input));

        assertEquals(exception.getMessage(), ILLEGAL_SIZE);
    }

    @Test
    void checkUserNumberError_메서드로_정상적인_입력값_테스트() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        List<Integer> continueGameInputList = List.of(1, 2);

        ErrorChecker errorChecker = new ErrorChecker(numberSize, startInclusive, endInclusive, continueGameInputList);

        String input = "789";

        Assertions.assertThatCode(() -> errorChecker.checkUserNumberError(input))
                .doesNotThrowAnyException();
    }

    @Test
    void checkUserNumberError_메서드로_잘못된_입력값_테스트() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        List<Integer> continueGameInputList = List.of(1, 2);

        ErrorChecker errorChecker = new ErrorChecker(numberSize, startInclusive, endInclusive, continueGameInputList);

        String input = "-10";

        assertThatThrownBy(() -> errorChecker.checkUserNumberError(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkUserNumberError_메서드로_잘못된_입력값_예외_메시지_테스트() {
        int numberSize = 3;
        int startInclusive = 1;
        int endInclusive = 9;
        List<Integer> continueGameInputList = List.of(1, 2);

        ErrorChecker errorChecker = new ErrorChecker(numberSize, startInclusive, endInclusive, continueGameInputList);

        String input = "-10";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> errorChecker.checkUserNumberError(input));

        assertEquals(exception.getMessage(), ILLEGAL_INPUT);
    }
}
