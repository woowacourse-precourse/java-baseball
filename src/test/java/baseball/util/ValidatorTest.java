package baseball.util;

import static baseball.Constants.EXIT;
import static baseball.Constants.START;
import static baseball.Constants.USER_INPUT_HAS_DUPLICATED_NUMBER;
import static baseball.Constants.USER_INPUT_IS_NOT_IN_RANGE;
import static baseball.Constants.USER_INPUT_IS_NOT_THREE_DIGITS;
import static baseball.Constants.USER_INPUT_IS_NULL_OR_EMPTY;
import static baseball.Constants.USER_INPUT_RANGE_ERROR;
import static baseball.util.Validator.validateUserInputHasDuplicateNumber;
import static baseball.util.Validator.validateUserInputIsMinRangeToMaxRange;
import static baseball.util.Validator.validateUserInputIsNullOrEmpty;
import static baseball.util.Validator.validateUserInputIsStartOrExit;
import static baseball.util.Validator.validateUserInputIsThreeDigits;
import static baseball.util.Validator.validateUserInputType;
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

    @Test
    void validateUserInputType_매서드로_사용자_입력값_타입을_확인() {
        // given
        String userInput1 = "123";
        String userInput2 = "";
        String userInput3 = " ";
        String userInput4 = "abc";

        // expected
        validateUserInputType(userInput1);
        assertThatThrownBy(() -> validateUserInputType(userInput2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateUserInputType(userInput3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateUserInputType(userInput4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUserInputIsStartOrExit_매서드_사용시_매개변수가_1또는_2가_아니면_예외_발생() {
        // given
        int userInput = 3;

        // expected
        assertThatThrownBy(() -> validateUserInputIsStartOrExit(userInput))
                .hasMessage(USER_INPUT_RANGE_ERROR)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUserInputIsStartOrExit_매서드_사용시_매개변수가_1또는_2라면_정상_동작() {
        // given
        int userInputSTART = START;
        int userInputEXIT = EXIT;

        // expected
        validateUserInputIsStartOrExit(userInputSTART);
        validateUserInputIsStartOrExit(userInputEXIT);
    }
}