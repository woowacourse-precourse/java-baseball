package baseball.validateInput;

import baseball.inputValidation.InputValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 값 유효성 검사")
class InputValidationTest {
    @Nested
    class 게임_리플레이_입력_테스트 {
        @Test
        void _0이_들어오면_예외가_발생한다() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> InputValidation.validateReplayInputValidation("0"));
        }

        @Test
        void 문자나_특수문자가_들어오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> InputValidation.validateReplayInputValidation("_"));
        }

        @Test
        void 공백이_들어오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> InputValidation.validateReplayInputValidation(""));
        }

        @Test
        void 두_글자_이상_들어오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> InputValidation.validateReplayInputValidation("11"));
        }
    }

    @Nested
    class 사용자_정답_입력_유효성_테스트 {
        @Test
        void 세글자_초과시_예외발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> InputValidation.validatePlayerInput("1234"));
        }

        @Test
        void 세글자_미만시_예외발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> InputValidation.validatePlayerInput("12"));
        }

        @Test
        void 숫자로만_이루어지지_않으면_예외발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> InputValidation.validatePlayerInput("12 "));
        }

        @Test
        void 중복되는_숫자가_있으면_예외발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> InputValidation.validatePlayerInput("122"));
        }
    }
}