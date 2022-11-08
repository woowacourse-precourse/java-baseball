package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @ValueSource(strings = {"36a", "cde", "86$", "!@#", "가나다"})
    @ParameterizedTest
    void 입력된_수가_숫자로만_이루어져있지_않으면_예외처리한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateOnlyNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아니거나 숫자로만 이루어져 있지 않습니다. 숫자만 입력해주세요.");
    }

    @ValueSource(strings = {"35", "2", "8643", "3852", "2834757"})
    @ParameterizedTest
    void 입력된_수가_3자리가_아니면_예외처리한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateThreeLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 수는 3자리가 아닙니다. 3자리로 구성된 수만 입력해주세요.");
    }

    @ValueSource(strings = {"355", "233", "898", "111", "665"})
    @ParameterizedTest
    void 입력된_수에_중복이_있으면_예외처리한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateDuplication(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 수에 중복이 있습니다. 각각 다른 숫자를 입력해주세요.");
    }

    @ValueSource(strings = {"707", "000", "340", "065", "006", "900"})
    @ParameterizedTest
    void 입력된_수에_0이_포함되어_있으면_예외처리한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateZeroIncluded(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 수에 0이 포함되어 있습니다. 0을 제외한 1부터 9 사이의 수를 입력해주세요.");
    }

    @ValueSource(strings = {"아니오", "게임종료", "NO", "X", "예", "ㄱㄴㄷ"})
    @ParameterizedTest
    void 게임_재시작_여부_응답_시에_숫자가_아닌_문자를_입력하면_예외처리한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateRestartOrEnd(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아니거나 숫자로만 이루어져 있지 않습니다. 숫자만 입력해주세요.");
    }

    @ValueSource(strings = {"3", "444", "55", "248", "0", "-1"})
    @ParameterizedTest
    void 게임_재시작_여부_응답_시에_1과_2가_아닌_다른_수를_입력하면_예외처리한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateRestartOrEnd(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 수는 선택지에 없습니다.");
    }
}