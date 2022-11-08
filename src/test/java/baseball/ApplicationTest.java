package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    class BaseballInputException {
        @Test
        void 중복된_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("112"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("중복된 입력입니다")
            );
        }

        @Test
        void 영문자_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력이 영어입니다")
            );
        }

        @Test
        void 한글_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("우테코"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력이 한글입니다")
            );
        }

        @Test
        void 숫자_0_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("102"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("0을 입력했습니다")
            );
        }

        @Test
        void 공백_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1 2"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("공백이 존재합니다")
            );
        }
    }

    class length_Exception {
        @Test
        void 자리수가_3자리_초과일떄() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력된 수가 3자리 초과입니다")
            );
        }

        @Test
        void 자리수가_3자리_미만일떄() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("12"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력된 수가 3자리 미만입니다")
            );
        }




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

}
