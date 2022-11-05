package baseball.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    @Nested
    @DisplayName("서로 다른 3자리의 수를 입력받는다.")
    class InputValidate {
        @DisplayName("숫자가 아닐 경우 IllegalArgumentException 예외를 throw한다.")
        @Test
        void validate_number() {
            Assertions.assertAll(
                    () -> assertThatThrownBy(() -> Input.validateInput("   "))
                            .isInstanceOf(IllegalArgumentException.class),
                    () -> assertThatThrownBy(() -> Input.validateInput("abc"))
                            .isInstanceOf(IllegalArgumentException.class),
                    () -> assertThatThrownBy(() -> Input.validateInput("!@#"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("3자리의 수가 아닐 경우 IllegalArgumentException 예외를 throw한다.")
        @Test
        void validate_length() {
            Assertions.assertAll(
                    () -> assertThatThrownBy(() -> Input.validateInput("12")),
                    () -> assertThatThrownBy(() -> Input.validateInput("1234"))
            );
        }

        @DisplayName("서로 다른 수가 아닐 경우 IllegalArgumentException 예외를 throw 한다.")
        @Test
        void validate_overlap() {
            assertThatThrownBy(() -> Input.validateInput("121")).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "정상 입력")
        @ValueSource(strings = {"123", "456", "789", "623", "985", "714"})
        void input(String text) {
            Assertions.assertDoesNotThrow(() -> Input.validateInput(text));
        }
    }
}
