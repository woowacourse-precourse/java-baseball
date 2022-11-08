package baseball.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserValidatorTest {
    private static UserValidator userValidator;

    @BeforeEach
    void BeforeEach() {
        userValidator = new UserValidator();
    }

    @Test
    void 공백이_섞이면_예외가_터진다() {
        String input = "1 3";

        assertThatThrownBy(() -> userValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 특수문자를_입력하면_예외가_터진다() {
        String input = "!@#";

        assertThatThrownBy(() -> userValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자가_하나라도_섞이면_예외가_터진다() {
        String input = "a23";

        assertThatThrownBy(() -> userValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력의_길이가_3보다_작다면_예외가_터진다() {
        String input = "12";

        assertThatThrownBy(() -> userValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력의_길이가_3보다_크다면_예외가_터진다() {
        String input = "1234";

        assertThatThrownBy(() -> userValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 같은_수를_중복해서_입력하면_예외가_터진다() {
        String input = "121";

        assertThatThrownBy(() -> userValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 서로다른_세자리의_숫자를_입력하면_예외가_터지지_않는다() {
        String input = "123";

        Assertions.assertDoesNotThrow(() -> userValidator.validateNumber(input));
    }

    @Test
    void 재시작_입력이_1또는_2가_아니면_예외가_터진다() {
        String input = "3";

        assertThatThrownBy(() -> userValidator.validateRestart(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력이_1이면_예외가_터지지_않는다() {
        String input = "1";

        Assertions.assertDoesNotThrow(() -> userValidator.validateRestart(input));
    }

    @Test
    void 재시작_입력이_2이면_예외가_터지지_않는다() {
        String input = "2";

        Assertions.assertDoesNotThrow(() -> userValidator.validateRestart(input));
    }

}
