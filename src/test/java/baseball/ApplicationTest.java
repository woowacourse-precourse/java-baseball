package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest {

    @Nested
    class MainTest extends NsTest {

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
        void 게임종료_후_예외_테스트() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("246", "893", "135", "147", "741", "3"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("1 또는 2를 입력해주세요.");
                        assertThat(output()).contains("1스트라이크", "낫싱", "1볼", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    7, 4, 1
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
    }

    @Nested
    class MethodTest {

        @Test
        void isRestartingGame_재시작_true_테스트() {
            String playerInput = "1";
            final byte[] buf = playerInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertThat(Application.isRestartingGame()).isTrue();
        }

        @Test
        void isRestartingGame_재시작_false_테스트() {
            String playerInput = "2";
            final byte[] buf = playerInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            assertThat(Application.isRestartingGame()).isFalse();
        }

        @Test
        void isRestartingGame_예외_테스트() {
            assertThatThrownBy(() -> {
                String playerInput = "4";
                final byte[] buf = playerInput.getBytes();
                System.setIn(new ByteArrayInputStream(buf));

                Application.isRestartingGame();
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1 또는 2를 입력해주세요.");
        }
    }
}
