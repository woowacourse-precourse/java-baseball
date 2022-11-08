package validator;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import validator.Validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest extends NsTest {
    @Test
    void 입력값_길이가_3이_아닌경우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("3개의 수만 입력 가능합니다.")
        );
    }

    @Test
    void 입력값_범위_내_숫자_아닌경우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("093"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1 ~ 9 사이의 숫자만 입력 가능합니다.")
        );
    }

    @Test
    void 입력값_숫자_아닌경우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1 ~ 9 사이의 숫자만 입력 가능합니다.")
        );
    }

    @Test
    void 입력값_중복되는_수_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("113"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("서로 다른 수만 입력 가능합니다.")
        );
    }

    @Test
    void 재시작_입력값_1_또는_2_이외_값_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validateRestartFlag("456"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1 또는 2만 입력 가능합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
