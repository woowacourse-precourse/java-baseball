package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameValidationTest {

    @DisplayName("지정된 게임 숫자 길이면 true 반환한다.")
    @Test
    void validateCorrectLength() {
        //given
        String number = "123";

        //when
        boolean result = GameValidation.validateLength(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("지정된 게임 숫자 길이보다 작은 경우 false 반환한다.")
    @Test
    void validateShortLength() {
        //given
        String number = "1";

        //when
        boolean result = GameValidation.validateLength(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("지정된 게임 숫자 길이보다 큰 경우 false 반환한다.")
    @Test
    void validateLongLength() {
        //given
        String number = "1234";

        //when
        boolean result = GameValidation.validateLength(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("플레이어의 게임 숫자의 각 자리가 모두 숫자면 true 반환한다.")
    @Test
    void validateCorrectDigit() {
        //given
        String number = "123";

        //when
        boolean result = GameValidation.validateDigit(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어의 게임 숫자에 영어가 포함되어 있으면 false 반환한다.")
    @Test
    void validateDigitWithAlphabet() {
        //given
        String number = "1a3";

        //when
        boolean result = GameValidation.validateDigit(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("플레이어의 게임 숫자에 기호가 포함되어 있으면 false 반환한다.")
    @Test
    void validateDigitWithSymbol() {
        //given
        String number = "1@3";

        //when
        boolean result = GameValidation.validateDigit(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("플레이어의 게임 숫자에 한글이 포함되어 있으면 false 반환한다.")
    @Test
    void validateDigitWithKorean() {
        //given
        String number = "1가3";

        //when
        boolean result = GameValidation.validateDigit(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("플레이어의 게임 숫자에 공백이 포함되어 있으면 false 반환한다.")
    @Test
    void validateDigitWithBlank() {
        //given
        String number = "1 3";

        //when
        boolean result = GameValidation.validateDigit(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("플레이어의 각 자리 게임 숫자가 정해진 범위에 포함되면 true 반환한다.")
    @Test
    void validateCorrectRange() {
        //given
        String number = "123";

        //when
        boolean result = GameValidation.validateRange(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어의 각 자리 게임 숫자가 정해진 범위에 벗어나면 false 반환한다.")
    @Test
    void validateOutOfRange() {
        //given
        String number = "103";

        //when
        boolean result = GameValidation.validateRange(number);

        //then
        assertThat(result).isFalse();
    }
}