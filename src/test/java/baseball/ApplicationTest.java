package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 재시작_입력값_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                assertThatThrownBy(() -> runException("246", "135", "12"))
                    .isInstanceOf(IllegalArgumentException.class);
            },1,3, 5
        );
    }

    @Test
    void 입력값_범위_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("120"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력값이_숫자인지_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("12a"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력값이_중복인지_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("122"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
