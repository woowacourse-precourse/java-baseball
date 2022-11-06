package baseball.domain;

import static baseball.StringEnum.InputExceptionCode.*;
import static org.assertj.core.api.Assertions.*;

import baseball.domain.Validation.InputValidation;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    @DisplayName("사용자 입력 난수에 문자 외의 값이 포함된 케이스를 확인한다")
    void 사용자_난수_입력시_문자_외의_값을_포함() {
        String input = "12 34";

        assertThatThrownBy(() -> InputValidation.validateBallInputFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_INCLUDE.toString());
    }

    @Test
    @DisplayName("사용자 입력 난수가 숫자로만 구성된 케이스를 확인한다")
    void 사용자_난수_입력시_문자_외의_값을_미포함() {
        String input = "123";

        InputValidation.validateBallInputFormat(input);

        //then: 예외가 발생하지 않는 경우 test pass
    }

    @Test
    @DisplayName("사용자 입력 난수가 3개인 케이스를 확인한다")
    void 사용자_난수_입력시_숫자_범위_개수_일치() {
        String input = "123";

        InputValidation.validateBallInputFormat(input);

        //then : 예외가 발생하지 않는 경우 test pass
    }

    @Test
    @DisplayName("사용자 입력 난수가 3개가 아닌 케이스를 확인한다")
    void 사용자_난수_입력시_숫자_범위_개수_불일치() {
        String input = "1234";

        assertThatThrownBy(() -> InputValidation.validateBallInputFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_3_NUMBERS.toString());
    }

    @Test
    @DisplayName("사용자 입력 난수가 1이상 9이하인 케이스를 확인한다")
    void 사용자_난수_입력시_난수_범위_일치() {
        List<Integer> numberList = List.of(1, 2, 3);

        InputValidation.validateBallInputNumber(numberList);

        //then : 예외가 발생하지 않는 경우 test pass
    }

    @Test
    @DisplayName("사용자 입력 난수가 1보다 작거나 9보다 큰 케이스를 확인한다")
    void 사용자_난수_입력시_난수_범위_불일치() {
        List<Integer> numberList = List.of(1, 0, 3);

        assertThatThrownBy(() -> InputValidation.validateBallInputNumber(numberList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_IN_RANGE.toString());
    }

    @Test
    @DisplayName("사용자 입력 난수에 중복값이 없는 케이스를 확인한다")
    void 사용자_난수_입력시_중복_없음() {
        List<Integer> numberList = List.of(1, 2, 3);

        InputValidation.validateBallInputNumber(numberList);

        //then : 예외가 발생하지 않는 경우 test pass
    }

    @Test
    @DisplayName("사용자 입력 난수에 중복값이 있는 케이스를 확인한다")
    void 사용자_난수_입력시_중복_존재() {
        List<Integer> numberList = List.of(1, 1, 3);

        assertThatThrownBy(() -> InputValidation.validateBallInputNumber(numberList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER.toString());
    }

}
