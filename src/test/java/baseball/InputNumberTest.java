package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberTest {

    @DisplayName("입력한 숫자 길이가 3이 아니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", ""})
    void inputNumberInvalidLength(String input) {
        assertThatThrownBy(() -> InputNumber.checkStringNumberLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 숫자길이가 3이 아닙니다.");
    }

    @DisplayName("입력한 내용이 숫자가 아니다.")
    @ParameterizedTest
    @ValueSource(strings = {"가나다", "abc"})
    void inputNumberInvalidNumber(String input) {
        assertThatThrownBy(() -> InputNumber.checkStringNumberIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 내용이 숫자가 아닙니다.");
    }
}