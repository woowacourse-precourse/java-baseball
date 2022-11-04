package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    void isLengthThree_InvalidInput_ExceptionThrown() {
        String invalidInput = "1111";
        Validator validator = new Validator(invalidInput);
        assertThatThrownBy(() -> validator.isLengthThree())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리의 숫자를 입력해주세요(ex. 123)");
    }

    @Test
    void isAllNumber_InvalidInput_ExceptionThrown() {
        String invalidInput = "1a3";
        Validator validator = new Validator(invalidInput);
        assertThatThrownBy(() -> validator.isAllNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리의 숫자를 입력해주세요(ex. 123)");
    }

    @Test
    void isAllDifferent_InvalidInput_ExceptionThrown() {
        String invalidInput = "113";
        Validator validator = new Validator(invalidInput);
        assertThatThrownBy(() -> validator.isAllDifferent())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3자리의 숫자를 입력해주세요(ex. 123)");
    }
}