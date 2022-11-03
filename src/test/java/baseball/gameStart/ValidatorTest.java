package baseball.gameStart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.utils.Validator;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1234", "1", "asd", "12a", "_12", "112", "122"})
    void user_answer_input_number_test(String input) {
        Assertions.assertThatThrownBy(() -> Validator.checkUserAnswerInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "3", "0", "4", "asd", "12a", "_12", "112", "122"})
    void user_finish_input_number_test(String input) {
        Assertions.assertThatThrownBy(() -> Validator.checkUserFinishInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
