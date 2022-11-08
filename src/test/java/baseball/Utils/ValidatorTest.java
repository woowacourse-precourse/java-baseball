package baseball.Utils;

import baseball.Utils.Validator;
import org.junit.jupiter.api.Test;

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
    void notContainsZero_InvalidInput_ExceptionThrown() {
        String invalidInput = "103";
        Validator validator = new Validator(invalidInput);
        assertThatThrownBy(() -> validator.notContainsZero())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 9까지의 숫자를 입력해주세요(ex. 159)");
    }

    @Test
    void isAllDifferent_InvalidInput_ExceptionThrown() {
        String invalidInput = "113";
        Validator validator = new Validator(invalidInput);
        assertThatThrownBy(() -> validator.isAllDifferent())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3자리의 숫자를 입력해주세요(ex. 123)");
    }

    @Test
    void isOneorTwo_InvalidInput_ExceptionThrown() {
        String invalidInput = "3";
        Validator validator = new Validator(invalidInput);
        assertThatThrownBy(() -> validator.isOneOrTwo())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작하려면 1, 종료하려면 2 둘 중 하나를 입력해주세요");
    }
}