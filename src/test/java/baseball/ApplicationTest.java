package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void _1볼_2볼_3볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("214", "213", "513", "135", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임_시작_메시지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "2");
                    assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임_승리_축하_메시지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "2");
                    assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임_재시작_메시지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "2");
                    assertThat(output()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트_잘못된_길이_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복된_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("225"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0을_포함한_잘못된_입력값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("078"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_알파벳을_포함한_잘못된_입력값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_공백을_포함한_잘못된_입력값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_게임_재시작시_잘못된_입력값() {
        assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                () -> {
                    run("135", "3");
                },
                1, 3, 5, 5, 8, 9
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
