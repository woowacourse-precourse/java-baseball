package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest extends NsTest {
    @Test
    void 일부터_구까지_숫자말고_다른것입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력숫자_자릿수범위_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 반복되는_숫자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
