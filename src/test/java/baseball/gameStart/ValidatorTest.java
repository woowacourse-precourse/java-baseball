package baseball.gameStart;

import baseball.utils.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void user_answer_input_length_test() {
        String input = "1234";
        Assertions.assertThatThrownBy(()-> Validator.checkUserAnswerInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
