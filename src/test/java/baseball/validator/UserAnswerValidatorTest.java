package baseball.validator;

import static org.assertj.core.api.Assertions.*;

import baseball.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserAnswerValidatorTest {

    private final UserAnswerValidator userAnswerValidator = new UserAnswerValidator();

    @DisplayName("새 게임 입력시 1, 2가 아닌 입력은 IllegalArgumentException 발생")
    @Test
    void validateNewGameAnswer_fail() {
        // given
        String tooLongInput = "12";
        String nonNumericInput = "a";

        // when
        // then
        assertThatThrownBy(() -> userAnswerValidator.validateNewGameAnswer(tooLongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEW_GAME_INPUT_EXCEPTION);
        assertThatThrownBy(() -> userAnswerValidator.validateNewGameAnswer(nonNumericInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEW_GAME_INPUT_EXCEPTION);
    }
}
