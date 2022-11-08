package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberTest extends NsTest {

    @Test
    void 사용자_입력값에_0이_포함된_경우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("109"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력값_3자리_숫자보다_작을_경우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력값에_숫자이외의_문자_포함된_경우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1x!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 사용자_입력값에_중복숫자_입력_시_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
