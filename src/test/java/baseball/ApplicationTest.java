package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 게임_한번만_진행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("213", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                2, 1, 3
        );
    }

    @Test
    void 게임_볼_혹은_스트라이크만_나올_때_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "356", "326", "132", "256", "216", "213", "2");
                    assertThat(output()).contains("낫싱", "1볼", "2볼", "3볼", "1스트라이크", "2스트라이크", "3스트라이크","게임 종료");
                },
                2, 1, 3
        );
    }

    @Test
    void 예외_테스트_길이() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복된_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("059"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
