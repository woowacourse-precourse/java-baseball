package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameValidationTest {

    @DisplayName("지정된 게임 숫자 길이면 false 반환한다.")
    @Test
    void isValidLength() {
        //given
        String number = "123";

        //when
        boolean result = GameValidation.isInvalidLength(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("지정된 게임 숫자 길이보다 작은 경우 true 반환한다.")
    @Test
    void isShortLength() {
        //given
        String number = "1";

        //when
        boolean result = GameValidation.isInvalidLength(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("지정된 게임 숫자 길이보다 큰 경우 true 반환한다.")
    @Test
    void isLongLength() {
        //given
        String number = "1234";

        //when
        boolean result = GameValidation.isInvalidLength(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어의 게임 숫자의 각 자리가 모두 숫자면 false 반환한다.")
    @Test
    void containsAllDigit() {
        //given
        String number = "123";

        //when
        boolean result = GameValidation.containsNotDigit(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("플레이어의 게임 숫자에 영어가 포함되어 있으면 true 반환한다.")
    @Test
    void containsDigitWithAlphabet() {
        //given
        String number = "1a3";

        //when
        boolean result = GameValidation.containsNotDigit(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어의 게임 숫자에 기호가 포함되어 있으면 true 반환한다.")
    @Test
    void containsDigitWithSymbol() {
        //given
        String number = "1@3";

        //when
        boolean result = GameValidation.containsNotDigit(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어의 게임 숫자에 한글이 포함되어 있으면 true 반환한다.")
    @Test
    void containsDigitWithKorean() {
        //given
        String number = "1가3";

        //when
        boolean result = GameValidation.containsNotDigit(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어의 게임 숫자에 공백이 포함되어 있으면 true 반환한다.")
    @Test
    void containsDigitWithBlank() {
        //given
        String number = "1 3";

        //when
        boolean result = GameValidation.containsNotDigit(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어의 각 자리 게임 숫자가 정해진 범위에 포함되면 false 반환한다.")
    @Test
    void containsValidRangeDigit() {
        //given
        String number = "123";

        //when
        boolean result = GameValidation.containsInvalidRangeDigit(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("플레이어의 각 자리 게임 숫자가 정해진 범위에 벗어나면 true 반환한다.")
    @Test
    void containsInvalidRangeDigit() {
        //given
        String number = "103";

        //when
        boolean result = GameValidation.containsInvalidRangeDigit(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어의 게임 숫자에 중복이 존재하지 않으면 false 반환한다.")
    @Test
    void containsNotDuplication() {
        //given
        String number = "123";

        //when
        boolean result = GameValidation.containsInvalidRangeDigit(number);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("플레이어의 게임 숫자에 중복이 존재하면 true 반환한다.")
    @Test
    void containsDuplication() {
        //given
        String number = "112";

        //when
        boolean result = GameValidation.containsDuplication(number);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("올바르지 않은 길이면 IllegalArgumentException 발생한다.")
    @Test
    void validateInvalidLength() {
        //given
        String number = "1234";

        //then
        Assertions.assertThatThrownBy(() -> GameValidation.validate(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자가 포함되면 IllegalArgumentException 발생한다.")
    @Test
    void validateContainsNotDigit() {
        //given
        String number = "1@4";

        //then
        Assertions.assertThatThrownBy(() -> GameValidation.validate(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정해진 범위가 아닌 숫자가 포함되면 IllegalArgumentException 발생한다.")
    @Test
    void validateContainsInvalidRange() {
        //given
        String number = "104";

        //then
        Assertions.assertThatThrownBy(() -> GameValidation.validate(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 숫자가 포함되면 IllegalArgumentException 발생한다.")
    @Test
    void validateContainsDuplication() {
        //given
        String number = "114";

        //then
        Assertions.assertThatThrownBy(() -> GameValidation.validate(number))
            .isInstanceOf(IllegalArgumentException.class);
    }
}