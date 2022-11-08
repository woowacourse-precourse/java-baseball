package baseball;

import baseball.constant.Message;
import baseball.validator.InputValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    void 입력받은_수의_타입을_검사한다() {
        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("12삼");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 입력받은_수의_자리_수를_검사한다() {
        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DIGIT_LENGTH_EXCEPTION);

        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DIGIT_LENGTH_EXCEPTION);

        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DIGIT_LENGTH_EXCEPTION);
    }

    @Test
    void 입력받은_수의_중복여부를_검사한다() {
        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("122");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DUPLICATION_EXCEPTION);

        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("111");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DUPLICATION_EXCEPTION);
    }

    @Test
    void 입력받은_수의_범위를_검사한다() {
        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("120");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DIGIT_RANGE_EXCEPTION);
    }

    @Test
    void 입력받은_수가_모든_테스트를_통과한다() {
        assertThatCode(() -> {
            InputValidator.validatePlayerNumber("123");
        }).doesNotThrowAnyException();

        assertThatCode(() -> {
            InputValidator.validatePlayerNumber("456");
        }).doesNotThrowAnyException();

        assertThatCode(() -> {
            InputValidator.validatePlayerNumber("789");
        }).doesNotThrowAnyException();
    }

    @Test
    void 게임상태를_나타내는_수의_타입을_검사한다() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("일");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);

        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("A");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);

        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("!");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);

        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 게임상태를_나타내는_수의_자리_수를_검사한다() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_LENGTH_EXCEPTION);

        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_LENGTH_EXCEPTION);
    }

    @Test
    void 게임상태를_나타내는_수의_범위를_검사한다() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_NUMBER_EXCEPTION);

        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_NUMBER_EXCEPTION);
    }
}
