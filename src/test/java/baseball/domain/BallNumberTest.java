package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    
    @Test
    @DisplayName("예외 처리 : 특수 문자")
    void special_characters_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallNumber("$"))
                .withMessage("잘못된 입력입니다. (1~9 범위의 3개 숫자만 입력 가능)");
    }
    
    @DisplayName("예외 처리 : 한글")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"ㄱ", "ㅏ", "가"})
    void consonant_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallNumber(input))
                .withMessage("잘못된 입력입니다. (1~9 범위의 3개 숫자만 입력 가능)");
    }
    
    @Test
    @DisplayName("예외 처리 : 공백")
    void space_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallNumber(" "))
                .withMessage("잘못된 입력입니다. (1~9 범위의 3개 숫자만 입력 가능)");
    }
    
    @DisplayName("예외 처리 : 범위를 벗어난 숫자")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"0", "10"})
    void exceed_range_exception(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallNumber(number))
                .withMessage("잘못된 입력입니다. (1~9 범위의 3개 숫자만 입력 가능)");
    }
}