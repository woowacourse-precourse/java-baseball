package baseball.validators;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayAgainOrNotValidatorTest {
    PlayAgainOrNotValidator playAgainOrNotValidator = new PlayAgainOrNotValidator();

    @Nested
    class 입력값이_제약조건에서_벗어나면_예외발생 {
        @Test
        void 입력값이_1_혹은_2가_아니면_예외발생() {
            // Given
            String input = "3";

            // When & Then
            assertThatThrownBy(() -> playAgainOrNotValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
