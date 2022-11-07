package baseball;

import baseball.exception.NotSuitableRegexException;
import baseball.exception.OverlapNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("재시작 요청 메시지 : 이상한 문자 입력시")
    void validRestartMessageWeirdCharacter() throws Exception {
        //given
        String message = "*";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateRestartMessage(message))
                .isInstanceOf(NotSuitableRegexException.class);
    }

    @Test
    @DisplayName("재시작 요청 메시지 : 1, 2 이외 숫자 입력시")
    void validRestartMessageAnotherNumber() throws Exception {
        //given
        String message = "3";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateRestartMessage(message))
                .isInstanceOf(NotSuitableRegexException.class);
    }
    @Test
    @DisplayName("재시작 요청 메시지 : 2자리 이상 숫자 입력시")
    void validRestartMessageExceededDigits() throws Exception {
        //given
        String message = "12";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateRestartMessage(message))
                .isInstanceOf(NotSuitableRegexException.class);
    }

    @Test
    @DisplayName("추측 값 입력 : 0 포함하여 입력시")
    void validInputZeroToGuessValue() throws Exception {
        //given
        String message = "904";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateGuessValueMessage(message))
                .isInstanceOf(NotSuitableRegexException.class);
    }

    @Test
    @DisplayName("추측 값 입력 : 숫자가 아닌 문자 입력시")
    void validInputWeirdCharacterToGuessValue() throws Exception {
        //given
        String message = "6*7";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateGuessValueMessage(message))
                .isInstanceOf(NotSuitableRegexException.class);
    }

    @Test
    @DisplayName("추측 값 입력 : 중복된 숫자 입력시")
    void validInputOverlapNumberToGuessValue() throws Exception {
        //given
        String message = "686";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateGuessValueMessage(message))
                .isInstanceOf(OverlapNumberException.class);
    }

    @Test
    @DisplayName("추측 값 입력 : 3자리 초과한 숫자 입력시")
    void validInputExceededDigits() throws Exception {
        //given
        String message = "6472";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateGuessValueMessage(message))
                .isInstanceOf(NotSuitableRegexException.class);
    }

}