package baseball;

import static baseball.Application.*;
import static baseball.Constants.*;
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

    @Test
    void makeOutput_매서드로_출력_문구를_반환() {
        // given
        // when
        String output1 = Application.makeOutput(0, 0);
        String output2 = Application.makeOutput(0, 1);
        String output3 = Application.makeOutput(1, 0);
        String output4 = Application.makeOutput(1, 1);
        String output5 = Application.makeOutput(0, 3);

        // then
        assertThat(output1).isEqualTo("낫싱");
        assertThat(output2).isEqualTo("1스트라이크");
        assertThat(output3).isEqualTo("1볼");
        assertThat(output4).isEqualTo("1볼 1스트라이크");
        assertThat(output5).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void isRoundFinish_매서드로_3스트라이크면_종료_반환() {
        // given
        int ballCount = 0;
        int strikeCount = 3;

        // when
        int result = Application.isRoundFinish(ballCount, strikeCount);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void isRoundFinish_매서드로_3스트라이크가_아니면_시작_반환() {
        // given
        int ballCount = 0;
        int strikeCount = 1;

        // when
        int result = Application.isRoundFinish(ballCount, strikeCount);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void validateUserInputType_매서드로_사용자_입력값_타입을_확인() {
        // given
        String userInput1 = "123";
        String userInput2 = "";
        String userInput3 = " ";
        String userInput4 = "abc";

        // expected
        Application.validateUserInputType(userInput1);
        assertThatThrownBy(() -> Application.validateUserInputType(userInput2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateUserInputType(userInput3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateUserInputType(userInput4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringToInt_메서드_사용시_string을_int로_변환() {
        // given
        String userInput = "123";

        // when
        int result = Application.stringToInt(userInput);

        // then
        assertThat(result).isEqualTo(123);
    }

    @Test
    void validateUserInputIsStartOrExit_매서드_사용시_매개변수가_1또는_2가_아니면_예외_발생() {
        // given
        int userInput = 3;

        // expected
        assertThatThrownBy(() -> Application.validateUserInputIsStartOrExit(userInput))
                .hasMessage(USER_INPUT_RANGE_ERROR)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUserInputIsStartOrExit_매서드_사용시_매개변수가_1또는_2라면_정상_동작() {
        // given
        int userInputSTART = 1;
        int userInputEXIT = 2;

        // expected
        Application.validateUserInputIsStartOrExit(userInputSTART);
        Application.validateUserInputIsStartOrExit(userInputEXIT);
    }
}