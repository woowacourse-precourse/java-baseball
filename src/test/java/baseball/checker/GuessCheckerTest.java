package baseball.checker;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GuessCheckerTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "451", "789"})
    void 정상_입력_테스트(String guess) {
        assertThatCode(() -> GuessChecker.check(guess))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "12", "1234"})
    void 입력_길이_오류(String guess) {
        assertThatThrownBy(() -> GuessChecker.check(guess))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "   ", ".;.", "-_-", "a2v", "012"})
    void 유효하지_않은_입력_문자_오류(String guess) {
        assertThatThrownBy(() -> GuessChecker.check(guess))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"121", "144", "111"})
    void 중복된_숫자_입력_오류(String guess) {
        assertThatThrownBy(() -> GuessChecker.check(guess))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
