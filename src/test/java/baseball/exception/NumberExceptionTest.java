package baseball.exception;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static baseball.exception.ExceptionMessage.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberExceptionTest extends NsTest {

    @Test
    void 중복_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("333"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATE_DIGIT_EXCEPTION.message())
        );
    }

    @Test
    void 글자수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12345"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_DIGIT_EXCEPTION.message())
        );
    }


    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NEGATIVE_DIGIT_EXCEPTION.message())
        );
    }

    @Test
    void 특수문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㄱㄴㄷ@"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_CHARACTER_EXCEPTION.message())
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
