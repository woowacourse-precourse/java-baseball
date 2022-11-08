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

    @Test
    void 추가_예외_테스트_예상_자리수_이하_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 추가_예외_테스트_빈문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 추가_예외_테스트_문자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("한글"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 심판_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "461", "361", "513", "895", "154", "153", "135", "2");
                    assertThat(output()).contains("낫싱", "1볼", "2볼", "3볼", "1스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
