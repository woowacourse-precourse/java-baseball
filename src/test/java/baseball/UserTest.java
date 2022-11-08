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
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예상숫자가_아닌_입력없음() {
        User user = new User();
        String userInput = "";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예상숫자가_아닌_공백_입력() {
        User user = new User();
        String userInput = "  ";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 세자리_내_입력() {
        User user = new User();
        String userInput = "1234";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 에상숫자_제로_0_입력(){
        User user = new User();
        String userInput = "000023";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다시플레이_여부_제로_0_입력(){
        User user = new User();
        String userInput = "0000000";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다시플레이_여부_문자열값(){
        User user = new User();
        String userInput = "000abc";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예상숫자_중복(){
        User user = new User();
        String userInput = "122";
        assertThatThrownBy(() -> {
            boolean result = user.validateUserGuessInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}