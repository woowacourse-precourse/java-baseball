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
    void 개수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 범위_예외_테스트_0포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("035"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 범위_예외_테스트_문자포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㄱㅇ3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 범위_예외_테스트_특수문자포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("!=3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                        () -> {
                            run("246", "135", "5");
                            assertThat(output()).contains("낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                        },
                        1, 3, 5
                )).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
