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
        assertRandomNumberInRangeTest(() -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 3, 5, 5, 8, 9);
    }

    @Test
    void 볼_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("513", "351", "135", "2");
            assertThat(output()).contains("3볼", "3볼", "3스트라이크");
        }, 1, 3, 5);
    }

    @Test
    void 게임종료_후_선택지_이외_선택() {
        assertRandomNumberInRangeTest(() -> assertThatThrownBy(() -> runException("135", "3")).isInstanceOf(IllegalArgumentException.class), 1, 3, 5);

    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 숫자_이외의_값() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("ㅁㄴㅇ")).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
