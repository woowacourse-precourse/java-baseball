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
    void 볼만있는_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                run("214", "213", "513", "135", "2");
                assertThat(output()).contains("1볼", "2볼", "3볼", "게임 종료");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임_시작() {
        assertRandomNumberInRangeTest(
            () -> {
                run("135", "2");
                assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임_종료_메시지_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("135", "2");
                assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임_재시작_여부_메시지_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("135", "2");
                System.out.println("output() = " + output());
                assertThat(output()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 잘못된_길이_입력_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임_재시작_상태_예외입력_테스트() {
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