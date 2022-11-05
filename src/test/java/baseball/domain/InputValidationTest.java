package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    @DisplayName("사용자_입력_난수에_문자_외의_값이_포함된_케이스를_확인한다")
    void 사용자_난수_입력시_문자_외의_값을_포함() {
        String input = "12 34";
        boolean result = false;

        assertThat(InputValidation.hasOnlyNumbers(input)).isEqualTo(result);
    }

    @Test
    @DisplayName("사용자_입력_난수가_숫자로만_구성된_케이스를_확인한다")
    void 사용자_난수_입력시_문자_외의_값을_미포함() {
        String input = "123";
        boolean result = true;

        assertThat(InputValidation.hasOnlyNumbers(input)).isEqualTo(result);
    }

}
