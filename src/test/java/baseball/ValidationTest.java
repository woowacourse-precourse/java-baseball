package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @Test
    @DisplayName("입력 값의 길이가 3보다 작은 경우 에러 발생")
    void inputValueLengthTest1() {
        String inputValue = "12";

        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.validateInputValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력 값의 길이가 3보다 큰 경우 에러 발생")
    void inputValueLengthTest2() {
        String inputValue = "12345";

        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.validateInputValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력 값에 0이 포함된 경우 에러 발생")
    void inputValueZeroContainedTest() {
        String inputValue = "140";

        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.validateInputValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 9까지의 숫자만 입력 가능합니다.");
    }
}