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
    class GameTest {
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
        void 게임종료_후_재시작_후_재시작() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("325", "145", "1", "847", "254", "1", "742", "2");
                        assertThat(output()).contains("1스트라이크", "3스트라이크", "1볼", "3스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 4, 5, 2, 5, 4, 7, 4, 2
            );
        }
    }

    @Nested
    class ExceptionTest {
        @Test
        void 숫자인지_체크() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력된 값은 숫자가 아닙니다")
            );
        }

        @Test
        void 세자리_수_숫자인지_체크() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력된 값은 세자리 수가 아닙니다")
            );
        }

        @Test
        void 서로_다른_3개의_수인지_체크() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("122"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("중복된 자리수가 존재합니다")
            );
        }

        @Test
        void 컨트롤_값이_숫자인지_체크() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> run("246", "135", "notNumeric"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("입력된 값은 숫자가 아닙니다");
                    },
                    1, 3, 5, 5, 8, 9
            );
        }

        @Test
        void 컨트롤_값이_이해가능한_값인지_체크() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> run("246", "135", "5"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("알 수 없는 컨트롤 값입니다");
                    },
                    1, 3, 5, 5, 8, 9
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
