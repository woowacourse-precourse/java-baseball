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
}
