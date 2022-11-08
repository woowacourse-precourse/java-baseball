package baseball.util.input;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.util.GameExceptionMessage;

import org.junit.jupiter.api.Test;

class NumberBallsUserInputTest {
    private NumberBallsInput makeNumberBallsInput(String numberBallsInput) {
        return new NumberBallsInput(numberBallsInput);
    }

    @Test
    void 문자열_입력_예외_발생() {
        assertThatThrownBy(() -> makeNumberBallsInput("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
    }

    @Test
    void 범위_밖_숫자_입력_예외_발생() {
        assertDoesNotThrow(() -> makeNumberBallsInput("013"));
        assertThatThrownBy(() -> makeNumberBallsInput("013").toNumberBalls())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_NUMBER_FROM_ONE_TO_NINE);
    }

    @Test
    void 숫자_세자리_미만_입력_예외_발생() {
        assertThatThrownBy(() -> makeNumberBallsInput("23"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
    }

    @Test
    void 숫자_세자리_초과_입력_예외_발생() {
        assertThatThrownBy(() -> makeNumberBallsInput("2345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
    }

    @Test
    void 문자열_숫자_합친_입력값_예외_발생() {
        assertThatThrownBy(() -> makeNumberBallsInput("12a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
    }

    @Test
    void 중복_숫자_입력값_예외_발생() {
        assertThatThrownBy(() -> makeNumberBallsInput("122"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
    }

    @Test
    void 중복_숫자_입력값_예외_발생2() {
        assertThatThrownBy(() -> makeNumberBallsInput("222"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
    }

    @Test
    void 빈_문자열_예외_발생() {
        assertThatThrownBy(() -> makeNumberBallsInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
    }

    @Test
    void 입력값_검증_성공() {
        assertDoesNotThrow(() -> makeNumberBallsInput("123"));
        assertDoesNotThrow(() -> makeNumberBallsInput("456"));
        assertDoesNotThrow(() -> makeNumberBallsInput("789"));
        assertDoesNotThrow(() -> makeNumberBallsInput("159"));
    }
}