package baseball.util;

import static baseball.Constants.USER_INPUT_HAS_DUPLICATED_NUMBER;
import static baseball.Constants.USER_INPUT_IS_NOT_IN_RANGE;
import static baseball.Constants.USER_INPUT_IS_NOT_THREE_DIGITS;
import static baseball.Constants.USER_INPUT_IS_NULL_OR_EMPTY;
import static baseball.util.Validator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validateUserInputIsNullOrEmpty_메서드_사용시_문자열이_null인_경우_예외_발생() {
        // given
        String userInput = null;

        // expected
        assertThatThrownBy(() ->
                validateUserInputIsNullOrEmpty(userInput))
                .hasMessage(USER_INPUT_IS_NULL_OR_EMPTY)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUserInputIsNullOrEmpty_메서드_사용시_빈_문자열인_경우_예외_발생() {
        // given
        String userInput = "";

        // expected
        assertThatThrownBy(() ->
                validateUserInputIsNullOrEmpty(userInput))
                .hasMessage(USER_INPUT_IS_NULL_OR_EMPTY)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUserInputIsOneToNine_메서드_사용시_문자열의_문자가_1에서_9가_아니면_예외_발생() {
        // given
        String userInput1 = "12a";
        String userInput2 = " ";
        String userInput3 = "abc";

        // expected
        assertThatThrownBy(() ->
                validateUserInputIsMinRangeToMaxRange(userInput1))
                .hasMessage(USER_INPUT_IS_NOT_IN_RANGE)
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                validateUserInputIsMinRangeToMaxRange(userInput2))
                .hasMessage(USER_INPUT_IS_NOT_IN_RANGE)
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                validateUserInputIsMinRangeToMaxRange(userInput3))
                .hasMessage(USER_INPUT_IS_NOT_IN_RANGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUserInputIsThreeDigit_메서드_사용시_문자열의_길이가_3이_아니면_예외_발생() {
        // given
        String userInput = "1234";

        // expected
        assertThatThrownBy(() ->
                validateUserInputIsThreeDigits(userInput))
                .hasMessage(USER_INPUT_IS_NOT_THREE_DIGITS)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUserInputHasDuplicateNumber_메서드_사용시_문자열에_중복된_문자가_있다면_예외_발생() {
        // given
        String userInput = "111";

        // expected
        assertThatThrownBy(() ->
                validateUserInputHasDuplicateNumber(userInput))
                .hasMessage(USER_INPUT_HAS_DUPLICATED_NUMBER)
                .isInstanceOf(IllegalArgumentException.class);
    }
}