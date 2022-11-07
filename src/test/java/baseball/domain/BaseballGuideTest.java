package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGuideTest {

    @DisplayName("올바르지 않은 길이면 IllegalArgumentException 발생한다.")
    @Test
    void validateInvalidLength() {
        //given
        String number = "1234";

        //then
        Assertions.assertThatThrownBy(() -> BaseballGuide.Validator.validate(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자가 포함되면 IllegalArgumentException 발생한다.")
    @Test
    void validateContainsNotDigit() {
        //given
        String number = "1@4";

        //then
        Assertions.assertThatThrownBy(() -> BaseballGuide.Validator.validate(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정해진 범위가 아닌 숫자가 포함되면 IllegalArgumentException 발생한다.")
    @Test
    void validateContainsInvalidRange() {
        //given
        String number = "104";

        //then
        Assertions.assertThatThrownBy(() -> BaseballGuide.Validator.validate(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 숫자가 포함되면 IllegalArgumentException 발생한다.")
    @Test
    void validateContainsDuplication() {
        //given
        String number = "114";

        //then
        Assertions.assertThatThrownBy(() -> BaseballGuide.Validator.validate(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

}