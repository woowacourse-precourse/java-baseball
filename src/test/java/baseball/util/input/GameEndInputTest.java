package baseball.util.input;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.util.GameExceptionMessage;
import org.junit.jupiter.api.Test;

class GameEndInputTest {
    GameEndInput makeGameEndInput(String gameEndInput) {
        return new GameEndInput(gameEndInput);
    }

    @Test
    void 숫자가_아닌_문자열_하나_입력_예외_발생() {
        assertThatThrownBy(() -> makeGameEndInput("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_CONTINUE_NUMBER_OR_EXIT_NUMBER);
    }

    @Test
    void 문자열_여러개_입력_예외_발생() {
        assertThatThrownBy(() -> makeGameEndInput("aaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_CONTINUE_NUMBER_OR_EXIT_NUMBER);
    }

    @Test
    void 빈_문자열_예외_발생() {
        assertThatThrownBy(() -> makeGameEndInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_CONTINUE_NUMBER_OR_EXIT_NUMBER);
    }

    @Test
    void 원하는_숫자가_아닌_입력_예외_발생() {
        assertThatThrownBy(() -> makeGameEndInput("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_CONTINUE_NUMBER_OR_EXIT_NUMBER);
    }

    @Test
    void 입력값_검증_성공() {
        assertDoesNotThrow(() -> makeGameEndInput("1"));
        assertDoesNotThrow(() -> makeGameEndInput("2"));
    }
}