package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest extends NsTest {

    @Test
    void 입력길이_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복값입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 범위외입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("109"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자외입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1c7"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
