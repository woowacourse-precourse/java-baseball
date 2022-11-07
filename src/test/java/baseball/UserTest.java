package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class UserTest {

    @Test
    void 예상숫자가_아닌_문자열_입력() {
        User user = new User();
        String userInput = "1234a";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 예상숫자가_아닌_입력없음() {
        User user = new User();
        String userInput = "";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 예상숫자가_아닌_공백_입력() {
        User user = new User();
        String userInput = " ";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 세자리_내_입력() {
        User user = new User();
        String userInput = "1234";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}