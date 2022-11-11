package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionTest extends NsTest {

    @Test
    @DisplayName("예외 테스트: 길이 테스트")
    void case1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 0 포함 여부 테스트")
    void case2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 정수 여부 테스트")
    void case3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("문자열"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 중복 여부 테스트")
    void case4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
