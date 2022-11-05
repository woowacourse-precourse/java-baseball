package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Nested
    class GameExecuteTest {
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
        void 게임종료_후_재시작_2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("357", "356", "536", "1", "567", "912", "589", "2");
                        assertThat(output()).contains("2볼", "2볼 1스트라이크", "3스트라이크", "1스트라이크", "1볼", "3스트라이크", "게임 종료");
                    },
                    5, 3, 6, 5, 8, 9
            );
        }
    }

    @Nested
    class GameExceptionTest {
        @Test
        void 예외_테스트_숫자_4개() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_테스트_중복_숫자() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("113"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_테스트_문자_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1a3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_테스트_범위_초과() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("053"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
