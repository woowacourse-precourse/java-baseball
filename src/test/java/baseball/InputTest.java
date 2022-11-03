package baseball;

import baseball.domain.Input;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {
    @Nested
    class InputGuessTest {
        @Test
        void case1() {
            String playerInput = "abc";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(playerInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void case2() {
            String playerInput = "1234";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(playerInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void case3() {
            String playerInput = "12";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(playerInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void case4() {
            String playerInput = "012";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(playerInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Input input = new Input();
        input.getPlayerGuess();
    }
}
