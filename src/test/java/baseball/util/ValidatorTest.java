package baseball.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    @Test
    void isVaildNumber_입력값의_길이가_짧은_경우() {
        assertThatThrownBy(() -> Validator.isVaildNumber("1", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isVaildNumber_입력값의_길이가_긴_경우() {
        assertThatThrownBy(() -> Validator.isVaildNumber("1234", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isVaildNumber_입력값에_0이_있는_경우() {
        assertThatThrownBy(() -> Validator.isVaildNumber("120", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isVaildNumber_입력값에_중복된_숫자가_있는_경우() {
        assertThatThrownBy(() -> Validator.isVaildNumber("121", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
