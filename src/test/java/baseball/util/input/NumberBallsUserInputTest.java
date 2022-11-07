package baseball.util.input;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.util.GameExceptionMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBallsUserInputTest {
    private NumberBallsInput makeNumberBallsInput(String numberBallsInput) {
        return new NumberBallsInput(numberBallsInput);
    }

    @Test
    @DisplayName("문자열로 생성 시 예외 발생")
    void exceptionCase1() {
        assertThatThrownBy(() -> makeNumberBallsInput("abc"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(GameExceptionMessage.USER_NUMBER_LENGTH);
    }

    @Test
    @DisplayName("0이 포함된 숫자로 NumberBall 생성 시 예외 발생")
    void exceptionCase2() {
        assertDoesNotThrow(() -> makeNumberBallsInput("013"));
        assertThatThrownBy(() -> makeNumberBallsInput("013").toNumberBalls())
                .isInstanceOf(IllegalArgumentException.class).hasMessage(GameExceptionMessage.USER_NUMBER_RANGE);
    }

    @Test
    @DisplayName("숫자 세자리 미만으로 생성 시 예외 발생")
    void exceptionCase3() {
        assertThatThrownBy(() -> makeNumberBallsInput("23"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(GameExceptionMessage.USER_NUMBER_LENGTH);
    }

    @Test
    @DisplayName("숫자 세자리 초과로 생성 시 예외 발생")
    void exceptionCase4() {
        assertThatThrownBy(() -> makeNumberBallsInput("2345"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(GameExceptionMessage.USER_NUMBER_LENGTH);
    }

    @Test
    @DisplayName("문자열과 숫자로 생성 시 예외 발생")
    void exceptionCase5() {
        assertThatThrownBy(() -> makeNumberBallsInput("12a"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(GameExceptionMessage.USER_NUMBER_LENGTH);
    }

    @Test
    @DisplayName("중복 숫자로 생성 시 예외 발생")
    void exceptionCase6() {
        assertThatThrownBy(() -> makeNumberBallsInput("122"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(GameExceptionMessage.USER_NUMBER_LENGTH);
    }

    @Test
    @DisplayName("중복 숫자로 생성 시 예외 발생2")
    void exceptionCase7() {
        assertThatThrownBy(() -> makeNumberBallsInput("222"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(GameExceptionMessage.USER_NUMBER_LENGTH);
    }

    @Test
    @DisplayName("빈문자열 예외 발생")
    void exceptionCase8() {
        assertThatThrownBy(() -> makeNumberBallsInput(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(GameExceptionMessage.USER_NUMBER_LENGTH);
    }

    @Test
    @DisplayName("성공 케이스")
    void successCase1() {
        assertDoesNotThrow(() -> makeNumberBallsInput("123"));
        assertDoesNotThrow(() -> makeNumberBallsInput("456"));
        assertDoesNotThrow(() -> makeNumberBallsInput("789"));
        assertDoesNotThrow(() -> makeNumberBallsInput("159"));
    }
}