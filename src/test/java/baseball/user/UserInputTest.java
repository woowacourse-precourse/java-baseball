package baseball.user;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputTest {

    private String testInput;
    private final UserInput userInput = new UserInput(() -> testInput);

    @Test
    @DisplayName("올바른 게임 인풋")
    void validInput() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        testInput = "123";
        assertIterableEquals(userInput.pitching(), expected);
    }

    @Test
    @DisplayName("올바른 옵션 인풋")
    void validOptionInput() {
        testInput = "1";
        assertTrue(userInput.isContinue());
    }

    @Test
    @DisplayName("올바르지 않는 옵션 인풋")
    void invalidOptionInput() {
        testInput = "3";
        assertThatThrownBy(userInput::isContinue).isInstanceOf(IllegalArgumentException.class);
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
        testInput = input;
        assertThatThrownBy(userInput::pitching).isInstanceOf(IllegalArgumentException.class);
    }

}
