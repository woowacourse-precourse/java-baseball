package baseball.exception;

import static baseball.exception.InputException.*;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputExceptionTest {

    @ParameterizedTest
    @ValueSource(strings = {"120", "12", "1234", "113", "-12", "a12"})
    @DisplayName("유저가 입력하는 형식이 잘못되었을 경우 예외발생")
    void selectUserNumberInputException(String input) {
        assertThatThrownBy(() -> validUserNumberException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "-1", "a", "9", "0", "12"})
    @DisplayName("유저가 종료 혹은 재시작 입력형식이 잘못되었을 경우 예외발생")
    void selectEndOrRestartInputException(String input) {
        assertThatThrownBy(() -> validRestartNumberException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
