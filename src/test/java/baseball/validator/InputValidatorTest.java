package baseball.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    void 사용자_입력이_null일경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            inputValidator.verifyUserInGameInput(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_입력이_3글자가_아닐경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            inputValidator.verifyUserInGameInput("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자입력이_0보다작거나같고_9보다클때_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            inputValidator.verifyUserInGameInput("012");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자의_입력이_각각_다르지_않을경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            inputValidator.verifyUserInGameInput("111");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자의_엔딩_선택지가_null일경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            inputValidator.verifyRestartOrEndInput(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자의_엔딩_선택지가_1혹은2가_아닐경우_예외발생() throws Exception {
        assertThatThrownBy(() -> {
            inputValidator.verifyRestartOrEndInput("3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}