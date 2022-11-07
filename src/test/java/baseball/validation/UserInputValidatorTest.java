package baseball.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

    @Test
    void validate() {
        //given
        UserInputValidator validator = new UserInputValidator();

        //when
        String input1 = "123 asdf";
        String input2 = "1234";
        String input3 = "-1234";
        String input4 = String.valueOf(Long.MAX_VALUE);
        String input5 = "92";
        String input6 = "113";
        String input7 = "123 456";

        //then
        Assertions.assertThatThrownBy(() -> validator.validateGuessInput(input1)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validator.validateGuessInput(input2)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validator.validateGuessInput(input3)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validator.validateGuessInput(input4)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validator.validateGuessInput(input5)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validator.validateGuessInput(input6)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validator.validateGuessInput(input7)).isInstanceOf(IllegalArgumentException.class);
    }
}