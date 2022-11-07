package baseball.validators;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ThreeDiffDigitValidatorTest {
    ThreeDiffDigitValidator threeDiffDigitValidator = new ThreeDiffDigitValidator();

    @Nested
    class 입력값이_제약조건에서_벗어나면_예외를_발생시킨다 {
        @Test
        void 입력값의_길이가_3보다_크면_예외를_발생시킨다() {
            // Given
            String input = "12343";

            // When & Then
            assertThatThrownBy(() -> threeDiffDigitValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void 입력값이_숫자타입으로_형변환_할_수_없는_문자열이면_예외를_발생시킨다() {
            // Given
            String input = "1@3$";

            // When & Then
            assertThatThrownBy(() -> threeDiffDigitValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        void 입력값의_각_자리수_중_중복값이_있다면_예외를_발생시킨다() {
            // Given
            String input = "122";

            // When & Then
            assertThatThrownBy(() -> threeDiffDigitValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
