package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

public class playGameTest extends NsTest {
    @Test
    void 문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("김재성"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_특수문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㅁㅁㅁ!@#@"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 올바르지_않은_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("107"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
