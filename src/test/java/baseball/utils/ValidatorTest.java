package baseball.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Nested
    @DisplayName("야구 게임 숫자 입력 테스트")
    class NumberInputTest {
        @Test
        @DisplayName("문자만 입력받는다면 예외가 발생한다")
        void 문자열_입력_테스트() {
            String inputStr = "예외문";

            Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("문자가 포함되어있으면 예외가 발생한다")
        void 문자열_숫자_입력_테스트() {
            String inputStr = "예2문";

            Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력받은 문자의 길이가 3이 아니라면 예외가 발생한다")
        void 입력_길이_테스트() {
            String inputStr = "2345";

            Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력받은 문자에 0이 포함된다면 예외가 발생한다")
        void 입력_범위_테스트() {
            String inputStr = "203";

            Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력받은 문자가 중복이 된다면 예외가 발생한다")
        void 중복_입력_테스트() {
            String inputStr = "233";

            Assertions.assertThatThrownBy(() -> Validator.validateNumberInput(inputStr))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("조건에 맞는 입력이 들어온다면 true를 반환한다")
        void 올바른_입력_테스트() {
            String inputStr = "234";

            Assertions.assertThat(Validator.validateNumberInput(inputStr)).isTrue();
        }
    }

    @Nested
    @DisplayName("야구 게임 재시작, 종료 테스트")
    class RestartInputTest {
        @Test
        @DisplayName("1, 2 보다 작은 수가 들어오면 예외가 발생한다")
        void 범위_미만_테스트() {
            String inputStr = "0";

            Assertions.assertThatThrownBy(() -> Validator.validateRestartInput(inputStr))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("1, 2보다 큰 수가 들어온다면 예외가 발생한다")
        void 범위_초과_테스트() {
            String inputStr = "3";

            Assertions.assertThatThrownBy(() -> Validator.validateRestartInput(inputStr))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자가 아닌 문자가 들어오면 예외가 발생한다")
        void 숫자_확인_테스트() {
            String inputStr = "냠";

            Assertions.assertThatThrownBy(() -> Validator.validateRestartInput(inputStr))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("길이를 초과하면 예외가 발생한다")
        void 길이_확인_테스트() {
            String inputStr = "22";

            Assertions.assertThatThrownBy(() -> Validator.validateRestartInput(inputStr))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("조건에 맞는 입력이 들어온다면 true를 반환한다")
        void 올바른_입력_테스트() {
            String inputStr = "1";

            Assertions.assertThat(Validator.validateRestartInput(inputStr)).isTrue();
        }
    }
}
