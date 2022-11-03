package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserInputNumbersTest {
    @Test
    void 입력값_테스트_정상입력() {
        String userInputValue = "123";
        boolean result = UserInputNumbers.validUserInputNumber(userInputValue);
        assertTrue(result);
    }

    @Test
    void 입력값_테스트_비정상입력_길이초과() {
        String userInputValue = "1234";
        assertThatThrownBy(() -> UserInputNumbers.validUserInputNumber(userInputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_테스트_비정상입력_길이미달() {
        String userInputValue = "1";
        assertThatThrownBy(() -> UserInputNumbers.validUserInputNumber(userInputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_테스트_비정상입력_문자포함() {
        String userInputValue = "12c";
        assertThatThrownBy(() -> UserInputNumbers.validUserInputNumber(userInputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_테스트_비정상입력_같은숫자포함() {
        String userInputValue = "224";
        assertThatThrownBy(() -> UserInputNumbers.validUserInputNumber(userInputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}