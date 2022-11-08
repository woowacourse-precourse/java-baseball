package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static baseball.userInterface.InputValidator.validateUserInput;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @Nested
    class inputValidateTest{
        @Test
        @DisplayName("세글자 이상 입력시 예외")
        void case1() {
            String input = "1234";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> validateUserInput(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("세글자 이하 입력시 예외")
        void case2() {
            String input = "12";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> validateUserInput(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("숫자가 아닌 문자 입력시 예외")
        void case3() {
            String input = "rsd";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> validateUserInput(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 숫자 입력시 예외 - 두글자 중복")
        void case4() {
            String input = "112";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> validateUserInput(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 숫자 입력시 예외 - 세글자 중복")
        void case5() {
            String input = "111";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> validateUserInput(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}
