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
    void 게임시작_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 게임시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("312", "213", "217", "273", "781", "783", "723", "123", "2");
                    assertThat(output())
                            .contains("3볼", "2볼 1스트라이크", "2볼", "1볼 1스트라이크", "1볼", "1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 게임시작_후_종료2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).contains("숫자 야구 게임을 시작합니다.", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", "게임 종료");
                },
                1, 2, 3
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
    void 입력값에_중복값이_포함되면_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_빈_값이_포함되면_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_숫자가_아닌_값이_포함되면_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_범위_안의_값이_포함되지_않으면_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_범위_안의_값이_포함되지_않으면_예외_발생2() {
        assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                () -> {
                    run("123", "3");
                },
                1, 2, 3
        )).isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
