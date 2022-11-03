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
}
