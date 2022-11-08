package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest extends NsTest {
    @Test
    void 숫자가_아닌_값이_포함된_경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 세자리_수가_아닌_경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 세자리_수가_아닌_경우_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 각_자리수가_중복되는_경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("131"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
