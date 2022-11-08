package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UserInputTest extends NsTest {
    @Nested
    class ComputerNumberTest {
        @org.junit.jupiter.api.Test
        void UserInputExceptionTest() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("asd"))
                            .isInstanceOf(IllegalArgumentException.class)
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(" "))
                            .isInstanceOf(IllegalArgumentException.class)
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("!@#"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @org.junit.jupiter.api.Test
        void InputNumberDuplicateTest() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("111"))
                            .isInstanceOf(IllegalArgumentException.class)
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("323"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @org.junit.jupiter.api.Test
        void RetryOrQuitTest() {
            Game game = new Game();

            System.setIn(new ByteArrayInputStream("3".getBytes()));
            assertThatThrownBy(game::retryOrQuit).isInstanceOf(IllegalArgumentException.class);

            System.setIn(new ByteArrayInputStream(" ".getBytes()));
            assertThatThrownBy(game::retryOrQuit).isInstanceOf(IllegalArgumentException.class);

            System.setIn(new ByteArrayInputStream("!@#".getBytes()));
            assertThatThrownBy(game::retryOrQuit).isInstanceOf(IllegalArgumentException.class);
        }
    }

        @Override
        public void runMain() {
            Application.main(new String[]{});
        }
    }