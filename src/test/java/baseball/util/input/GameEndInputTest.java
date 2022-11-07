package baseball.util.input;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.util.GameExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameEndInputTest {
    GameEndInput makeGameEndInput(String gameEndInput) {
        return new GameEndInput(gameEndInput);
    }

    @Test
    @DisplayName("문자열 하나 들어왔을 경우 예외 발생")
    void exceptionCase1() {
        assertThatThrownBy(() -> makeGameEndInput("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.CONTINUE_OR_EXIT);
    }

    @Test
    @DisplayName("문자열 여러 개 들어왔을 경우 예외 발생")
    void exceptionCase2() {
        assertThatThrownBy(() -> makeGameEndInput("aaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.CONTINUE_OR_EXIT);
    }

    @Test
    @DisplayName("문자열 아무것도 안들어왔을 경우 예외 발생")
    void exceptionCase3() {
        assertThatThrownBy(() -> makeGameEndInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.CONTINUE_OR_EXIT);
    }

    @Test
    @DisplayName("1, 2가 아닌 숫자가 들어왔을 경우 예외 발생")
    void exceptionCase4() {
        assertThatThrownBy(() -> makeGameEndInput("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.CONTINUE_OR_EXIT);
    }

    @Test
    @DisplayName("1, 2 숫자가 들어왔을 경우 성공")
    void successCase1() {
        assertDoesNotThrow(() -> makeGameEndInput("1"));
        assertDoesNotThrow(() -> makeGameEndInput("2"));
    }
}