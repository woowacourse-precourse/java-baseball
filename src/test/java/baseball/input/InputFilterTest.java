package baseball.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static baseball.input.InputFilter.convertToNumbers;
import static baseball.input.InputFilter.splitToLetters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputFilterTest {

    @DisplayName("splitToLetters 메서드 테스트")
    @ParameterizedTest
    @CsvSource({
            "123, '[1, 2, 3]'",
            "456, '[4, 5, 6]'",
            "789, '[7, 8, 9]'"
    })
    void splitToLetters_Test(String input, String letters) {
        assertEquals(letters, Arrays.toString(splitToLetters(input)));
    }

    @DisplayName("convertToNumbers 메서드 테스트")
    @ParameterizedTest
    @CsvSource({
            "123, '[1, 2, 3]'",
            "456, '[4, 5, 6]'",
            "789, '[7, 8, 9]'"
    })
    void splitToLetters_And_ConvertToNumbers_Test(String input, String letters) {
        assertEquals(letters, convertToNumbers(splitToLetters(input)).toString());
    }

    @DisplayName("splitToLetters 메서드에 null값 입력 시 예외 테스트")
    @ParameterizedTest
    @EmptySource
    void splitToLetters_NullInput_IllegalArgumentExceptionThrown(String input) {
        assertThatThrownBy(() -> splitToLetters(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null값이 입력되었습니다.");
    }

    @DisplayName("convertToNumbers 입력값 검증 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "12345", "203"})
    void convertToNumbers_InvalidLengthInput_IllegalArgumentExceptionThrown(String input) {
        assertThatThrownBy(() -> convertToNumbers(splitToLetters(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("허용되지 않은 형식의 입력값입니다.");
    }
}
