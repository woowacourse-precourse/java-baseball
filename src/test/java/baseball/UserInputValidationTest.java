package baseball;

import baseball.model.UserInputValidation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputValidationTest {
    UserInputValidation inputValidation;

    @ParameterizedTest
    @ValueSource(strings = {"1234", "001", "a5d", "ㅎ71", ""})
    void isNumberValid(String input) {
        inputValidation = new UserInputValidation();
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.getUserInput(input));
    }
}
