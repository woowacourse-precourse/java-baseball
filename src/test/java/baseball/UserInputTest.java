package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputTest {

    private static class InputBox {
        String testInput;
    }

    private InputBox inputBox = new InputBox();
    private UserInput userInput = new UserInput(() -> {
        return inputBox.testInput;
    });

    @Test
    @DisplayName("올바른 게임 인풋")
    void validInput() {
        Integer[] expected = new Integer[]{1, 2, 3};
        inputBox.testInput = "123";
        assertArrayEquals(expected, userInput.getGameInput());
    }

    @Test
    @DisplayName("올바른 옵션 인풋")
    void validOptionInput() {
        inputBox.testInput = "1";
        assertEquals(userInput.isContinue(), true);
    }

    @Test
    @DisplayName("올바르지 않는 옵션 인풋")
    void invalidOptionInput() {
        inputBox.testInput = "3";
        assertThatThrownBy(() -> userInput.isContinue())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0 입력 게임 인풋")
    void invalidDigitZero() {
        testGameInputException("102");
    }

    @Test
    @DisplayName("올바르지 않은 문자 길이 게임 인풋")
    void invalidInputLength() {
        testGameInputException("1234");
    }

    @Test
    @DisplayName("문자열 입력 게임 인풋")
    void invalidCharacter() {
        testGameInputException("abc");
    }

    @Test
    @DisplayName("중복 숫자 게임 인풋")
    void invalidDuplicatedDigits() {
        testGameInputException("112");
    }

    @Test
    @DisplayName("문자와 숫자 혼용 게임 인풋")
    void invalidMixedInput() {
        testGameInputException("1a2");
    }

    private void testGameInputException(String input) {
        inputBox.testInput = input;
        assertThatThrownBy(() -> userInput.getGameInput())
            .isInstanceOf(IllegalArgumentException.class);
    }

}
