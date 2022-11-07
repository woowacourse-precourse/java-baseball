package baseball.domain.validation;

import static baseball.stringenum.InputExceptionCode.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Nested
    @DisplayName("사용자 공 숫자 입력 검증을 테스트한다")
    class testPlayerBallInput {

        @Test
        @DisplayName("사용자 입력 난수에 숫자 외의 값이 포함된 케이스를 확인한다")
        void 사용자_난수_입력시_숫자_외의_값을_포함() {
            String input = "12 34";

            assertThatThrownBy(() -> InputValidation.validateBallInputFormat(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_NUMBER_INCLUDE.toString());
        }

        @Test
        @DisplayName("사용자 입력 난수가 숫자로만 구성된 케이스를 확인한다")
        void 사용자_난수_입력시_숫자_외의_값을_미포함() {
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

    @Nested
    @DisplayName("사용자 재시작 여부 입력 검증을 테스트한다")
    class testPlayerRestartInput {

        @Test
        @DisplayName("사용자 입력 값에 숫자 외의 값이 포함된 케이스를 확인한다")
        void 사용자_재시작_입력시_숫자_외의_값을_포함() {
            String input = "1/";

            assertThatThrownBy(() -> InputValidation.validateRestartInput(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_RESTART_NUMBER.toString());
        }

        @Test
        @DisplayName("사용자 입력 값에 숫자로만 구성된 케이스를 확인한다")
        void 사용자_재시작_입력시_숫자_외의_값을_미포함() {
            String input = "1";

            InputValidation.validateRestartInput(input);

            //then: 예외가 발생하지 않는 경우 test pass
        }

        @Test
        @DisplayName("사용자 입력 값이 시스템이 지정한 값이 아닌 경우를 테스트 한다")
        void 사용자_재시작_입력시_지정된_값_외의_값_입력() {
            int input = 3;

            assertThatThrownBy(() -> InputValidation.validateIsRestart(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_RESTART_NUMBER.toString());
        }

        @Test
        @DisplayName("사용자 입력 난수가 3개가 아닌 케이스를 확인한다")
        void 사용자_난수_입력시_숫자_범위_개수_불일치() {
            int input = 2;

            InputValidation.validateIsRestart(input);

            //then : 예외가 발생하지 않는 경우 test pass
        }
    }


}
