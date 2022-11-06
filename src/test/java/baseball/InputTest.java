package baseball;

import baseball.view.Input;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {
    @Nested
    class InputGuessTest extends NsTest{
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

        @Test
        void case5() {
            final byte[] buf = String.join("\n", "123").getBytes();
            ArrayList<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(1);
            expectedResult.add(2);
            expectedResult.add(3);

            Input input = new Input();
            System.setIn(new ByteArrayInputStream(buf));
            ArrayList<Integer> result = input.readPlayerGuess();

            assertThat(result).isEqualTo(expectedResult);
        }

        @Override
        public void runMain() {
            Input input = new Input();
            input.readPlayerGuess();
        }
    }

    @Nested
    class InputChoiceTest extends NsTest{
        @Test
        void case1() {
            String playerInput = "3";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(playerInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void case2() {
            String playerInput = "12";
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
            String playerInput = "a";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(playerInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Override
        public void runMain() {
            Input input = new Input();
            input.readPlayerChoice();
        }
    }
}
