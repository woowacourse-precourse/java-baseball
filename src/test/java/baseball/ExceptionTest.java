package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest {
    Exception exception = new Exception();

    @Test
    void checkValidInputTest() {
        String input = "369";
        boolean result = exception.checkIllegalInput(input);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void checkInvalidLengthTest() {
        String input = "3333";
        assertThatThrownBy(() -> exception.checkIllegalInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.INVALID_LENGTH_ERROR_MSG);
    }

    @Test
    void checkInvalidFormatTest() {
        String input = "19a";
        assertThatThrownBy(() -> exception.checkIllegalInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.INVALID_FORMAT_ERROR_MSG);
    }

    @Test
    void checkDuplicateNumberTest() {
        String input = "191";
        assertThatThrownBy(() -> exception.checkIllegalInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.DUPLICATE_NUMBER_ERROR_MSG);
    }
}