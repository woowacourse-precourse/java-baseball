package baseball.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserInputValidatorTest {

    @Test
    void 유효성_검증_성공_테스트() {
        UserInputValidator.validateAnswer("123");
        UserInputValidator.validateAnswer("456");
        UserInputValidator.validateAnswer("789");
        UserInputValidator.validateAnswer("925");
        UserInputValidator.validateAnswer("571");
        UserInputValidator.validateAnswer("274");
        UserInputValidator.validateAnswer("523");
        UserInputValidator.validateAnswer("672");
    }

    @Test
    void 유효성_검증_실패_테스트() {
        assertThatThrownBy(() -> UserInputValidator.validateAnswer("a1b"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserInputValidator.validateAnswer("!#3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserInputValidator.validateAnswer("4566"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserInputValidator.validateAnswer("112"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserInputValidator.validateAnswer("102"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}