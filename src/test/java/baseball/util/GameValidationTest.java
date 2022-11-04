package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameValidationTest {

    @DisplayName("지정된 게임 숫자 길이인 경우 true 반환한다.")
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
}