package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerInputViewTest {

    @Test
    @DisplayName("입력 길이가 3보다 긴지 판정")
    void checkInputLengthMoreThan3() {
        String input = "1234";

        assertThatThrownBy(() -> PlayerInputView.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 길이가 3보다 짧은지 판정")
    void checkInputLengthLessThan3() {
        String input = "12";

        assertThatThrownBy(() -> PlayerInputView.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 문자가 중복인지 판정")
    void checkInputDuplicateNumber() {
        String input = "122";

        assertThatThrownBy(() -> PlayerInputView.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 문자에 숫자가 아닌 문자가 있는지 판정")
    void checkInputInvalidNumber() {
        String input = "12a";

        assertThatThrownBy(() -> PlayerInputView.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 문자에 0이 있는지 판정")
    void checkInputNumberZero() {
        String input = "102";

        assertThatThrownBy(() -> PlayerInputView.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
