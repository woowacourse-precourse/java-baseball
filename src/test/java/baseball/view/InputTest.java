package baseball.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    @DisplayName("숫자가 아닐 경우 IllegalArgumentException 예외를 throw한다.")
    @Test
    void validate_number() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> Input.validateNumber("   "))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateNumber("abc"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateNumber("!@#"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("3자리의 수가 아닐 경우 IllegalArgumentException 예외를 throw한다.")
    @Test
    void validate_length() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> Input.validateLength("12")),
                () -> assertThatThrownBy(() -> Input.validateLength("1234"))
        );
    }

    @DisplayName("서로 다른 수가 아닐 경우 IllegalArgumentException 예외를 throw 한다.")
    @Test
    void validate_overlap() {
        assertThatThrownBy(() -> Input.validateOverlap("121")).isInstanceOf(IllegalArgumentException.class);
    }
}
