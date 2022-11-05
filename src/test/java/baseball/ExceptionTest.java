package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest {
    Exception exception = new Exception();

    @Test
    void checkValidInputTest() {
        String input = "369";
        boolean result = exception.checkIllegalGameInput(input);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void checkInvalidLengthTest() {
        String input = "3333";
        assertThatThrownBy(() -> exception.checkIllegalGameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.INVALID_LENGTH_ERROR_MSG);
    }

    @Test
    void checkInvalidFormatTest() {
        String input = "19a";
        assertThatThrownBy(() -> exception.checkIllegalGameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.INVALID_FORMAT_ERROR_MSG);
    }

    @Test
    void checkDuplicateNumberTest() {
        String input = "191";
        assertThatThrownBy(() -> exception.checkIllegalGameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.DUPLICATE_NUMBER_ERROR_MSG);
    }

    @Test
    void checkValidRestartInputTest() {
        String input = "1";
        boolean result = exception.checkIllegalRestartInput(input);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void checkInvalidRestartInputTest() {
        String input = "ㄱ";
        assertThatThrownBy(() -> exception.checkIllegalRestartInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.INVALID_RESTART_FORMAT_MSG);
    }
}