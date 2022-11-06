package baseball;

import baseball.exception.ExceptionCode;
import baseball.exception.GameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class IsNumberTest {
    @Test
    void 정상_테스트() {
        //given
        String input = "123";
        //when
        Throwable throwable = catchThrowable(() -> isNumber(input));
        //then
        assertThat(throwable)
                .isNull();
    }

    @Test
    void 예외_테스트_공백() {
        //given
        String input = " 123";
        //when
        Throwable throwable = catchThrowable(() -> isNumber(input));
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }

    @Test
    void 예외_테스트_문자() {
        //given
        String input = "ㅁ123";
        //when
        Throwable throwable = catchThrowable(() -> isNumber(input));
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }

    void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new GameException(ExceptionCode.INPUT_NOT_VALID);
        }
    }
}
