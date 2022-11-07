package baseball;

import baseball.validator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 입력받은_수의_타입을_검사한다() {
        assertThatThrownBy(() -> {
            inputValidator.validatePlayerNumber("12삼");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 입력받은_수의_자리_수를_검사한다() {
        assertThatThrownBy(() -> {
            inputValidator.validatePlayerNumber("1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DIGIT_LENGTH_EXCEPTION);
    }

    @Test
    void 입력받은_수의_중복여부를_검사한다() {
        assertThatThrownBy(() -> {
            inputValidator.validatePlayerNumber("122");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DUPLICATION_EXCEPTION);
    }

    @Test
    void 입력받은_수의_범위를_검사한다() {
        assertThatThrownBy(() -> {
            inputValidator.validatePlayerNumber("120");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DIGIT_RANGE_EXCEPTION);
    }

    @Test
    void 게임상태를_나타내는_수의_타입을_검사한다() {
        assertThatThrownBy(() -> {
            inputValidator.validateStateNumber("일");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 게임상태를_나타내는_수의_자리_수를_검사한다() {
        assertThatThrownBy(() -> {
            inputValidator.validateStateNumber("12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_LENGTH_EXCEPTION);
    }

    @Test
    void 게임상태를_나타내는_수의_범위를_검사한다() {
        assertThatThrownBy(() -> {
            inputValidator.validateStateNumber("3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_NUMBER_EXCEPTION);
    }
}
