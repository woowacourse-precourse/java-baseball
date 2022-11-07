package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserNumberTest extends NsTest {
    @Test
    void notNumberInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㄱ12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void duplicateNumberInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("223"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void outOfRangeInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("709"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void restartInput() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("713", "ㄱ"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                7, 1, 3
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
