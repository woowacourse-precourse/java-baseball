package baseball;

import baseball.exception.GameException;
import baseball.gameComponents.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class IsPositiveNumberTest {
    private Validator validator = new Validator();
    @Test
    void 정상_테스트() {
        //given
        String input = "123";
        //when
        Throwable throwable = catchThrowable(() -> validator.isPositiveNumber(input));
        //then
        assertThat(throwable)
                .isNull();
    }

    @Test
    void 예외_테스트_공백포함() {
        //given
        String input = " 123";
        //when
        Throwable throwable = catchThrowable(() -> validator.isPositiveNumber(input));
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }

    @Test
    void 예외_테스트_문자() {
        //given
        String input = "ㅁ123";
        //when
        Throwable throwable = catchThrowable(() -> validator.isPositiveNumber(input));
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }

    @Test
    void 예외_테스트_공백() {
        //given
        String input = "";
        //when
        Throwable throwable = catchThrowable(() -> validator.isPositiveNumber(input));
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }

    @Test
    void 예외_테스트_음수() {
        //given
        String input = "-123";
        //when
        Throwable throwable = catchThrowable(() -> validator.isPositiveNumber(input));
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }

    @Test
    void 예외_테스트_음수2() {
        //given
        String input = "-1-23";
        //when
        Throwable throwable = catchThrowable(() -> validator.isPositiveNumber(input));
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }
}
