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
    void 기타문자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 공_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("101"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공_사이즈_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 중복_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class));
    }
    @Test
    void 스트라이크_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("145", "125", "123", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 볼_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("127", "872", "897", "789", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼", "3스트라이크", "게임 종료");
                },
                7, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
