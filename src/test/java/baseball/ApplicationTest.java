package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
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
                assertThatThrownBy(() -> runException("abc", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Nested
    class 예외_테스트 {
        @Test
        void 숫자_자리수_체크1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("12"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 숫자_자리수_체크() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }


        @Test
        void 빈_문자열() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(""))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 숫자가_아닌_값() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 숫자_0_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("103"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 중복된_값_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("343"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
