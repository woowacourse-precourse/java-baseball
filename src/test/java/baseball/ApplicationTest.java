package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Nested
    class 게임종료_후_재시작 {
        @Test
        void case1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "2");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
        }

        @Test
        void case2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "234", "345", "456", "2");
                        assertThat(output()).contains("낫싱", "1볼", "2볼", "3스트라이크", "게임 종료");
                    },
                    4, 5, 6
            );
        }

        @Test
        void case3() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "1", "823", "834", "2");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9, 8, 3, 4
            );
        }
    }

    @Nested
    class 예외_테스트 {
        @Test
        @DisplayName("입력의 길이가 4인 경우")
        void case1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("입력의 길이가 2인 경우")
        void case2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("12"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("숫자 외 입력이 포함된 경우")
        void case3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1q2"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 숫자가 포함된 경우112")
        void case4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("112"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 숫자가 포함된 경우211")
        void case5() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("211"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 숫자가 포함된 경우111")
        void case6() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("111"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 숫자가 포함된 경우121")
        void case7() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("121"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 숫자가 포함된 경우556")
        void case8() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("556"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("0이 포함된 경우")
        void case9() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("012"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
