package baseball;

import baseball.model.UserInputValidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputValidationTest {
    UserInputValidation inputValidation;
    @BeforeEach
    void setUp() {
        inputValidation = new UserInputValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "001", "a5d", "ㅎ71", ""})
    void isNumberValid(String input) {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.getUserInput(input));
    }

    @Test
    void changeInput() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = inputValidation.changeInputtoInt("123");
        assertEquals(expected, actual);
    }
}
