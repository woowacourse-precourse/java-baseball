package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionControllerTest {
    @Nested
    @DisplayName("세자리 수가 아닐 때 예외발생 테스트")
    class Not3LengthInputTest {
        @Test
        void 네자리_수가_주어진_경우() {
            String input = "1234";
            assertThatThrownBy(() -> ExceptionController.handleInvalidThreeRandomNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("세 자리 수를 입력해야 합니다.");
        }

        @Test
        void 두자리_수가_주어진_경우() {
            String input = "12";
            assertThatThrownBy(() -> ExceptionController.handleInvalidThreeRandomNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("세 자리 수를 입력해야 합니다.");
        }
    }

    @Nested
    @DisplayName("숫자가 아닌 값이 섞여있을 때 예외발생 테스트")
    class NotNumberInputTest {
        @Test
        void 공백이_포함된_경우() {
            String input = "1 2";
            assertThatThrownBy(() -> ExceptionController.handleInvalidThreeRandomNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자만 입력해야 합니다.");
        }

        @Test
        void 영문자가_포함된_경우() {
            String input = "12a";
            assertThatThrownBy(() -> ExceptionController.handleInvalidThreeRandomNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자만 입력해야 합니다.");
        }

        @Test
        void 특수문자가_포함된_경우() {
            String input = "12*";
            assertThatThrownBy(() -> ExceptionController.handleInvalidThreeRandomNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자만 입력해야 합니다.");
        }
    }

    @Nested
    @DisplayName("입력에 중복된 숫자가 있을 때 예외발생 테스트")
    class DuplicatedNumberInputTest {
        @Test
        void 중복된_숫자가_입력된_경우() {
            String input = "122";
            assertThatThrownBy(() -> ExceptionController.handleInvalidThreeRandomNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("서로 다른 세 개의 수를 입력해야 합니다.");
        }
    }

    @Nested
    @DisplayName("종료코드 입력값이 유효하지 않을 때 예외발생 테스트")
    class InvalidFinishCodeTest {
        @Test
        void 유효하지_않은_숫자가_입력된_경우_1() {
            String input = "3";
            assertThatThrownBy(() -> ExceptionController.handleInvalidFinishCode(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1 또는 2를 입력해야 합니다.");
        }

        @Test
        void 유효하지_않은_숫자가_입력된_경우_2() {
            String input = "*1";
            assertThatThrownBy(() -> ExceptionController.handleInvalidFinishCode(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1 또는 2를 입력해야 합니다.");
        }
    }
}