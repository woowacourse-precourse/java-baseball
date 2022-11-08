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

    @Nested
    class checkPlayerInputTest {
        @Test
        @DisplayName("3개보다 많은 값이 입력된 경우 테스트")
        void case1() {
            String line = "1234";
            assertThatThrownBy(() -> Application.checkPlayerInput(line))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("3개보다 적은 값이 입력된 경우 테스트")
        void case2() {
            String line = "12";
            assertThatThrownBy(() -> Application.checkPlayerInput(line))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("빈 값이 입력된 경우 테스트")
        void case3() {
            String line = "";
            assertThatThrownBy(() -> Application.checkPlayerInput(line))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자가 아닌 값이 포함되어 입력된 경우 테스트")
        void case4() {
            String line = "12a";
            assertThatThrownBy(() -> Application.checkPlayerInput(line))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("0이 포함되어 입력된 경우 테스트")
        void case5() {
            String line = "102";
            assertThatThrownBy(() -> Application.checkPlayerInput(line))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복된 숫자가 입려된 경우 테스트")
        void case6() {
            String line = "122";
            assertThatThrownBy(() -> Application.checkPlayerInput(line))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("1에서 9사이가 아닌 값이 입력된 경우 테스트")
        void case7() {
            String line = "abc";
            assertThatThrownBy(() -> Application.checkPlayerInput(line))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class checkNewGameInputTest {
        @Test
        @DisplayName("1 또는 2가 아닌 값이 입력된 경우 테스트")
        void case1() {
            String line = "3";
            assertThatThrownBy(() -> Application.checkNewGameInput(line))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("빈 값이 입력된 경우 테스트")
        void case3() {
            String line = "";
            assertThatThrownBy(() -> Application.checkNewGameInput(line))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
