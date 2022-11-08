package baseball.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberExceptionTest {

    @DisplayName("중복된 숫자를 입력 받았을 때 예외를 던진다.")
    @Test
    void 중복_숫자_예외_테스트() {
        String number = "323";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberValidator.isNotDuplicateNumber(number);
        });
        assertThat(exception.getMessage()).isEqualTo(DUPLICATE_DIGIT_EXCEPTION.message());
    }

    @DisplayName("세글자가 아닌 숫자를 입력 받았을 때 예외를 던진다.")
    @Test
    void 글자수_예외_테스트() {
        String number = "12345";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberValidator.isThreeDigits(number);
        });
        assertThat(exception.getMessage()).isEqualTo(INVALID_DIGIT_EXCEPTION.message());
    }


    @DisplayName("음수를 입력 받았을 때 예외를 던진다.")
    @Test
    void 음수_예외_테스트() {
        String number = "-123";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberValidator.isPositiveDigits(number);
        });
        assertThat(exception.getMessage()).isEqualTo(NEGATIVE_DIGIT_EXCEPTION.message());
    }

    @DisplayName("한글, 영문, 특수문자가 포함된것을 입력 받았을 때 예외를 던진다.")
    @Test
    void 특수문자_예외_테스트() {
        String number = "ㄱㄴㄷ@";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberValidator.isDigit(number);
        });
        assertThat(exception.getMessage()).isEqualTo(INVALID_CHARACTER_EXCEPTION.message());
    }

    @DisplayName("재시작과 종료 명령어 제외 다른 것을 입력 받았을때 예외를 던진다.")
    @Test
    void 명령어_예외_테스트() {
        String number = "3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberValidator.isValidCommandDigit(number);
        });
        assertThat(exception.getMessage()).isEqualTo(INVALID_COMMAND_DIGIT_EXCEPTION.message());
    }
}
