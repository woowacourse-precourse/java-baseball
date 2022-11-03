package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallNumberTest {
    @DisplayName("예외 처리 : 알파벳")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"a", "A"})
    void alphabet_exception(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallNumber(number))
                .withMessage("잘못된 입력입니다. (1~9 범위의 3개 숫자만 입력 가능)");
    }
}