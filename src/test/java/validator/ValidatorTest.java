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
        String validLengthCase = "123";
        String longLengthCase = "1234";
        String shortLengthCase = "12";

        assertThat(Validator.validateLength(validLengthCase, unitSize)).isTrue();
        assertThatThrownBy(() -> Validator.validateLength(longLengthCase, unitSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateLength(shortLengthCase, unitSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_VALIDATION_FAILED);
    }

    @Test
    @DisplayName("입력 내용이 모두 숫자로 구성되어 있는 지 확인")
    void validate_each_digit_test() {
        String validCase = "123";
        String includeAlphabetCase = "12a";
        String includeSpaceCase = "12 ";
        String includeCharacterCase = "12$";
        String includeUnderBarCase = "12_";
        String includeZeroCase = "120";

        assertThat(Validator.validateEachCharIsNumberAndNotZero(validCase))
                .isTrue();
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(includeAlphabetCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(includeSpaceCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(includeCharacterCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(includeUnderBarCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsNumberAndNotZero(includeZeroCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
    }

    @Test
    @DisplayName("입력된 내용이 서로 다른 숫자로 구성되어 있는 지 확인")
    void validate_no_duplication_test() {
        String validCase = "123";
        String dupleTwoCase = "122";
        String dupleThreeCase = "333";

        assertThat(Validator.validateEachCharIsUnique(validCase))
                .isTrue();
        assertThatThrownBy(() -> Validator.validateEachCharIsUnique(dupleTwoCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATION_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validateEachCharIsUnique(dupleThreeCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATION_VALIDATION_FAILED);
    }

    @Test
    @DisplayName("게임에서 사용할 수 있는 값인 가에 대한 종합적인 평가를 잘 하는 지 확인")
    void validate_test() {
        String validCase = "123";
        String longLength = "1234";
        String includeCharacterCase = "12a";
        String dupleTwoCase = "122";
        String includeZeroCase = "120";

        assertThat(Validator.validate(validCase)).isTrue();
        assertThatThrownBy(() -> Validator.validate(longLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validate(includeCharacterCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validate(dupleTwoCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATION_VALIDATION_FAILED);
        assertThatThrownBy(() -> Validator.validate(includeZeroCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_VALIDATION_FAILED);
    }
}
