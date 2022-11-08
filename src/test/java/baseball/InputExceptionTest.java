package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputExceptionTest {

    @DisplayName("사용자 입력값이 형식에 맞지않으면 예외가 발생한다.")
    @CsvSource({"1234", "12", "가나", "sdg", "1가3"})
    @ParameterizedTest
    void validInput(String input) {
        assertThatThrownBy(() -> InputException.validInput(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력값이 비어있으면 예외가 발생한다.")
    @Test
    void validInput() {
        assertThatThrownBy(() -> InputException.validInput(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
