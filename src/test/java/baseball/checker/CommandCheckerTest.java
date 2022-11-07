package baseball.checker;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommandCheckerTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "23", "123"})
    void 입력_길이_오류(String command) {
        assertThatThrownBy(() -> CommandChecker.check(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "a", ".", ";", "`"})
    void 유효하지_않은_입력_오류(String command) {
        assertThatThrownBy(() -> CommandChecker.check(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 정상_입력_테스트(String command) {
        assertThatCode(() -> CommandChecker.check(command))
                .doesNotThrowAnyException();
    }
}
