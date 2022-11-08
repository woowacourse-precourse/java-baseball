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
            assertRandomNumberInRangeTest(() -> {
                run("246", "135", "1", "597", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
            }, 1, 3, 5, 5, 8, 9);
        }

        @Test
        void 게임_시작_후_바로_종료() {
            assertRandomNumberInRangeTest(() -> {
                run("948", "2");
                assertThat(output()).contains("3스트라이크", "게임 종료");
            }, 9, 4, 8);
        }

        @Test
        void 게임_한번_후_종료() {
            assertRandomNumberInRangeTest(() -> {
                run("256", "526", "265", "165", "315", "135", "2");
                assertThat(output()).contains("1볼", "1볼", "1스트라이크", "2스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
            }, 1, 3, 5, 5, 8, 9);
        }

        @Test
        void 게임_한번_후_재시작_후_바로_종료() {
            assertRandomNumberInRangeTest(() -> {
                run("391", "531", "536", "1", "789", "2");
                assertThat(output()).contains("1볼", "2스트라이크", "3스트라이크", "3스트라이크", "게임 종료");
            }, 5, 3, 6, 7, 8, 9);
        }

        @Test
        void 게임_두번_후_종료() {
            assertRandomNumberInRangeTest(() -> {
                run("357", "356", "536", "1", "567", "912", "589", "1", "123", "2");
                assertThat(output()).contains("2볼", "2볼 1스트라이크", "3스트라이크", "1스트라이크", "1볼", "3스트라이크", "3스트라이크", "게임 종료");
            }, 5, 3, 6, 5, 8, 9, 1, 2, 3);
        }
    }


    @Nested
    class GameExceptionTest {
        @Test
        void 예외_테스트_숫자_4개() {
            assertSimpleTest(
                    () -> assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 예외_테스트_중복_숫자() {
            assertSimpleTest(
                    () -> assertThatThrownBy(() -> runException("113"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 예외_테스트_문자_입력() {
            assertSimpleTest(
                    () -> assertThatThrownBy(() -> runException("1a3"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 예외_테스트_특수기호_입력() {
            assertSimpleTest(
                    () -> assertThatThrownBy(() -> runException("1'7"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 예외_테스트_영_포함() {
            assertSimpleTest(
                    () -> assertThatThrownBy(() -> runException("053"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 예외_테스트_문자_숫자_4개() {
            assertSimpleTest(
                    () -> assertThatThrownBy(() -> runException("53ba"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("3자리의 숫자를 입력해주세요(ex. 123)"));
        }

        @Test
        void 예외_테스트_영_포함_중복_숫자() {
            assertSimpleTest(
                    () -> assertThatThrownBy(() -> runException("055"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("1부터 9까지의 숫자를 입력해주세요(ex. 159)"));
        }

        @Test
        void 예외_테스트_네_글자_특수기호() {
            assertSimpleTest(
                    () -> assertThatThrownBy(() -> runException("562;"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("3자리의 숫자를 입력해주세요(ex. 123)"));
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
