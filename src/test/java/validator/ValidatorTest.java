package validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private static final String LENGTH_VALIDATION_FAILED
            = "입력한 숫자의 길이가 3이 아닙니다.";
    private static final String DIGIT_VALIDATION_FAILED
            = "입력내용은 모두 1~9 사이의 숫자로 구성되어야 합니다.";
    private static final String DUPLICATION_VALIDATION_FAILED
            = "입력내용은 서로 다른 3개의 숫자로 구성되어 합니다.";

    @Test
    @DisplayName("입력한 수의 길이가 3임을 정확히 검증하는 가?")
    void validate_length_test() {
        int unitSize = 3;
        String input1 = "123";
        String input2 = "1234";
        String input3 = "12";

        assertThat(Validator.validateLength(input1, unitSize)).isTrue();
        assertThatThrownBy(() -> Validator.validateLength(input2, unitSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateLength(input3, unitSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_VALIDATION_FAILED);
    }

    @Test
    @DisplayName("입력 내용이 모두 숫자로 구성되어 있는 지 확인")
    void validate_each_digit_test() {
        String input1 = "123";
        String input2 = "12a";
        String input3 = "12 ";
        String input4 = "12$";
        String input5 = "12_";
        String input6 = "120";

        assertThat(Validator.validateEachCharIsNumberAndNotZero(input1))
                .isTrue();
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(input4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(input5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(input6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
    }

    @Test
    @DisplayName("입력된 내용이 서로 다른 숫자로 구성되어 있는 지 확인")
    void validate_no_duplication_test() {
        String input1 = "123";
        String input2 = "122";
        String input3 = "333";

        assertThat(Validator.validateEachCharIsUnique(input1))
                .isTrue();
        assertThatThrownBy(() -> Validator.validateEachCharIsUnique(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATION_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsUnique(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATION_VALIDATION_FAILED);
    }

    @Test
    @DisplayName("게임에서 사용할 수 있는 값인 가에 대한 종합적인 평가를 잘 하는 지 확인")
    void validate_test() {
        String input1 = "123";
        String input2 = "1234";
        String input3 = "12a";
        String input4 = "122";
        String input5 = "120";

        assertThat(Validator.validate(input1)).isTrue();
        assertThatThrownBy(() -> Validator.validate(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validate(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validate(input4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATION_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validate(input5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
    }
}
