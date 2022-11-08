package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumTest {

    @Nested
    class validate_test {
        @Test
        void case1() {
            String input = "112";
            InputNum i = new InputNum();

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> i.validateInput(input, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void case2() {
            String input = "1234";
            InputNum i = new InputNum();

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> i.validateInput(input, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void case3() {
            String input = "e34";
            InputNum i = new InputNum();

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> i.validateInput(input, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}
