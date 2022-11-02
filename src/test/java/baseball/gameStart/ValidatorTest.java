package baseball.gameStart;

import baseball.utils.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @Test
    void user_answer_input_length_test() {
        String input = "1234";
        Assertions.assertThatThrownBy(() -> Validator.checkUserAnswerInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "12s", "12_"})
    void user_answer_input_number_test(String input) {
        Assertions.assertThatThrownBy(() -> Validator.checkUserAnswerInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "322", "556"})
    void user_answer_input_duplicate_test(String input) {
        Assertions.assertThatThrownBy(() -> Validator.checkUserAnswerInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
