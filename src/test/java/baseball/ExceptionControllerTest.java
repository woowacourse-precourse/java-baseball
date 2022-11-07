package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionControllerTest {
    @Nested
    class 세자리_수가_아닐_때_예외발생_테스트 {
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
    class 숫자가_아닌_값이_섞여있을_때_예외발생_테스트 {
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
}