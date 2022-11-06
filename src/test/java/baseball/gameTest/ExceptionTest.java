package baseball.gameTest;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest extends NsTest {
    @Test
    void moreNumberInputExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void lessNumberInputExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void outOfRangeExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void notNumberExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void duplicatedNumberExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void catchSpaceExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void catchWrongOrderRestartExceptionTest() {
        assertRandomNumberInRangeTest(
                () ->
                {
                    assertThatThrownBy(()->run("123","3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1,2,3
        );
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
