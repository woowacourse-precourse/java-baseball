package baseball;

import baseball.exception.GameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GameExceptionTest {
    @Nested
    class runCodeTest {
        GameException gameException = new GameException();

        @Test
        void input_1() {
            Assertions.assertThatCode(() -> gameException.runCodeValidation(1))
                    .doesNotThrowAnyException();
        }

        @Test
        void input_2() {
            Assertions.assertThatCode(() -> gameException.runCodeValidation(2))
                    .doesNotThrowAnyException();
        }

        @Test
        void input_others() {
            Assertions.assertThatThrownBy(() -> gameException.runCodeValidation(3))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자가 1 또는 2가 아닙니다. 프로그램을 종료합니다.");
            Assertions.assertThatThrownBy(() -> gameException.runCodeValidation(0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자가 1 또는 2가 아닙니다. 프로그램을 종료합니다.");
            Assertions.assertThatThrownBy(() -> gameException.runCodeValidation(-1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자가 1 또는 2가 아닙니다. 프로그램을 종료합니다.");
            Assertions.assertThatThrownBy(() -> gameException.runCodeValidation(9))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자가 1 또는 2가 아닙니다. 프로그램을 종료합니다.");
        }
    }

    @Nested
    class runCodeLengthTest {
        GameException gameException = new GameException();

        @Test
        void length_0() {
            Assertions.assertThatThrownBy(() -> gameException.runCodeLengthException(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자의 개수가 올바르지 않습니다. 프로그램을 종료합니다.");
        }

        @Test
        void length_1() {
            Assertions.assertThatCode(() -> gameException.runCodeLengthException("1"))
                    .doesNotThrowAnyException();
        }

        @Test
        void length_2() {
            Assertions.assertThatThrownBy(() -> gameException.runCodeLengthException("-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자의 개수가 올바르지 않습니다. 프로그램을 종료합니다.");
            Assertions.assertThatThrownBy(() -> gameException.runCodeLengthException("12"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자의 개수가 올바르지 않습니다. 프로그램을 종료합니다.");
        }

        @Test
        void length_3() {
            Assertions.assertThatThrownBy(() -> gameException.runCodeLengthException("-12"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자의 개수가 올바르지 않습니다. 프로그램을 종료합니다.");
            Assertions.assertThatThrownBy(() -> gameException.runCodeLengthException("123"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("입력한 숫자의 개수가 올바르지 않습니다. 프로그램을 종료합니다.");
        }

    }
}
