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

    @DisplayName("올바른 게임 결과가 나오는지 테스트")
    @Nested
    class ExceptionHandle {
        @Test
        void 예외_글자길이_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_중복문자_테스트() {
            Player player = new Player();

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> player.setNumber("313"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_0포함_테스트() {
            Player player = new Player();

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> player.setNumber("130"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_잘못된_게임_종료값_입력() {
            assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                    () -> {
                        run("456", "0");
                        assertThat(output()).contains("3스트라이크");
                    },
                    4, 5, 6
            )).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
