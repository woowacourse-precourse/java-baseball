package baseball;

import static baseball.Application.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.junit.jupiter.api.Test;

class MethodTest {

    @Test
    void generateThreeDigitNumber_메서드_사용시_서로_다른_세_자리_수를_생성() {
        //given
        List<Integer> result;

        //when
        result = generateThreeDigitsNumber();

        //then
        assertThat(result).isNotNull();

        assertThat(result.size()).isEqualTo(3);

        for (Integer number : result) {
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(9);
        }

        Set<Integer> set = new HashSet<>(result);
        assertThat(set.size()).isEqualTo(3);

        List<Integer> temp = generateThreeDigitsNumber();
        assertThat(result).isNotSameAs(temp);
    }

    @Test
    void validateUserInputIsNullOrEmpty_메서드_사용시_빈_문자열인_경우_예외_발생n() {
        // given
        String userInput = "\n";

        // when
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        // then
        assertThatThrownBy(() ->
                validateUserInputIsNullOrEmpty(scanner.nextLine()))
                .hasMessage(USER_INPUT_IS_NULL_OR_EMPTY)
                .isInstanceOf(IllegalArgumentException.class);
    }

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
    void stringToIntList_매서드_사용시_String을_Integer_형_List_로_변환() {
        // given
        String userInput = "123";

        // when
        List<Integer> result = Application.stringToIntList(userInput);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void countStrikeInUserInput_매서드로_사용자_입력값에_strike가_몇_개있는지_반환() {
        // given
        List<Integer> answer = List.of(1, 4, 5);
        List<Integer> userInput = List.of(1, 2, 3);

        // when
        int result = Application.countStrikeInUserInput(userInput, answer);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void countBallInUserInput_매서드로_사용자_입력값에_ball이_몇_개있는지_반환() {
        // given
        List<Integer> answer = List.of(3, 4, 5);
        List<Integer> userInput = List.of(1, 2, 3);

        // when
        int result = Application.countBallInUserInput(userInput, answer);

        // then
        assertThat(result).isEqualTo(1);
    }
}