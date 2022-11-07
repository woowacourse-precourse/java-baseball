package baseball.domain;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("예외 처리 상세 테스트")
class ValidatorTest extends NsTest {

    @DisplayName("숫자 외의 입력값 예외 처리 테스트 1")
    @Test
    void case1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자만 입력해주세요.")
        );
    }

    @DisplayName("숫자 외의 입력값 예외 처리 테스트 2")
    @Test
    void case2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12~"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자만 입력해주세요.")
        );
    }

    @DisplayName("숫자 범위 예외 처리 테스트 1")
    @Test
    void case3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("104"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1에서 9사이의 숫자만 입력해주세요.")
        );
    }

    @DisplayName("숫자 범위 예외 처리 테스트 2")
    @Test
    void case4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1에서 9사이의 숫자만 입력해주세요.")
        );
    }

    @DisplayName("숫자 길이 예외 처리 테스트")
    @Test
    void case5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("올바른 길이의 숫자를 입력해주세요.")
        );
    }

    @DisplayName("숫자 중복 예외 처리 테스트")
    @Test
    void case6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("933"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("서로 다른 숫자를 입력해주세요.")
        );
    }

    @DisplayName("게임 종료 후 숫자 외의 입력깂 예외 처리 테스트")
    @Test
    void case7() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() ->
                                run("123", "asd"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("숫자만 입력해주세요."),
                1, 2, 3
        );
    }

    @DisplayName("1 또는 2가 아닌 입력값 예외 처리 테스트")
    @Test
    void case8() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() ->
                                run("123", "3"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("1 또는 2를 입력해주세요."),
                1, 2, 3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
