package baseball;

import baseball.constant.Message;
import baseball.validator.InputValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class InputValidatorTest {
    @Test
    void 입력받은_수의_타입을_검사한다() {
        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("12삼");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 입력받은_수의_자리_수를_검사한다_입력이_없는_경우() {
        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DIGIT_LENGTH_EXCEPTION);
    }

    @Test
    void 입력받은_수의_자리_수를_검사한다_미만인_경우() {
        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DIGIT_LENGTH_EXCEPTION);
    }


    @Test
    void 입력받은_수의_자리_수를_검사한다_초과인_경우() {
        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DIGIT_LENGTH_EXCEPTION);
    }


    @Test
    void 입력받은_수의_중복여부를_검사한다_2글자_중복() {
        assertThatThrownBy(() -> {
            InputValidator.validatePlayerNumber("122");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DUPLICATION_EXCEPTION);
    }

    @Test
    void 입력받은_수의_중복여부를_검사한다_3글자_중복() {
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
        assertAll(
                () -> assertThatCode(() -> {
                    InputValidator.validatePlayerNumber("123");
                }).doesNotThrowAnyException(),

                () -> assertThatCode(() -> {
                    InputValidator.validatePlayerNumber("645");
                }).doesNotThrowAnyException(),

                () -> assertThatCode(() -> {
                    InputValidator.validatePlayerNumber("798");
                }).doesNotThrowAnyException()
        );
    }

    @Test
    void 게임상태_수의_타입을_검사한다_한글() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("일");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 게임상태_수의_타입을_검사한다_알파벳() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("A");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 게임상태_수의_타입을_검사한다_특수문자() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("!");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 게임상태_수의_타입을_검사한다_공백() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.TYPE_EXCEPTION);
    }

    @Test
    void 게임상태_수의_자리_수를_검사한다_미만인_경우() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_LENGTH_EXCEPTION);
    }

    @Test
    void 게임상태_수의_자리_수를_검사한다_초과인_경우() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_LENGTH_EXCEPTION);
    }

    @Test
    void 게임상태_수의_범위를_검사한다_미만인_경우() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_VALUE_EXCEPTION);
    }

    @Test
    void 게임상태_수의_범위를_검사한다_초과인_경우() {
        assertThatThrownBy(() -> {
            InputValidator.validateStateNumber("3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.STATE_VALUE_EXCEPTION);
    }

    @Test
    void 게임상태_수가_모든_테스트를_통과한다() {
        assertAll(
                () -> assertThatCode(() -> {
                    InputValidator.validateStateNumber("1");
                }).doesNotThrowAnyException(),

                () -> assertThatCode(() -> {
                    InputValidator.validateStateNumber("2");
                }).doesNotThrowAnyException()
        );
    }
}
