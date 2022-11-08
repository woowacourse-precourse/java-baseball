package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @Test
    @DisplayName("입력 값의 길이가 3보다 작은 경우")
    void inputValueLengthTest1() {
        String inputValue = "12";

        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.validateInputValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값의 길이가 3보다 큰 경우")
    void inputValueLengthTest2() {
        String inputValue = "12345";

        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.validateInputValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값에 문자가 포함된 경우")
    void inputValueCharContainedTest() {
        String inputValue = "a12";

        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.validateInputValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값에 0이 포함된 경우")
    void inputValueZeroContainedTest() {
        String inputValue = "012";

        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.validateInputValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값에 중복된 숫자가 포함된 경우")
    void inputValueDuplicateNumberTest() {
        String inputValue = "122";

        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.validateInputValue(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 종료 후 1 또는 2가 아닌 다른 값을 입력한 경우")
    void inputValueIsOneOrTwoTest() {
        String inputValue = "3";

        InputValidation inputValidation = new InputValidation();
        assertThatThrownBy(() -> inputValidation.validateIsOneOrTwo(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}