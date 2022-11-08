package baseball.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("문자만 입력받는다면 예외가 발생한다")
    void 문자열_입력_테스트() {
        String inputStr = "예외문";

        Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자가 포함되어있으면 예외가 발생한다")
    void 문자열_숫자_입력_테스트() {
        String inputStr = "예2문";

        Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 문자의 길이가 3이 아니라면 예외가 발생한다")
    void 입력_길이_테스트() {
        String inputStr = "2345";

        Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 문자에 0이 포함된다면 예외가 발생한다")
    void 입력_범위_테스트() {
        String inputStr = "203";

        Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 문자가 중복이 된다면 예외가 발생한다")
    void 중복_입력_테스트() {
        String inputStr = "233";

        Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("조건에 맞는 입력이 들어온다면 true를 반환한다")
    void 올바른_입력_테스트() {
        String inputStr = "234";

        Assertions.assertThat(Validator.validateNumberInput(inputStr)).isTrue();
    }
}
