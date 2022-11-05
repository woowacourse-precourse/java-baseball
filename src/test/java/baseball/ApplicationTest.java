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
    void 입력이_세자리가_아닌경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 숫자가 세 자리가 아닙니다.")
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9123"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 숫자가 세 자리가 아닙니다.")
        );
    }

    @Test
    void 입력이_숫자가_아닌경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("q12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 내용 중에 숫자가 아닌 값이 있습니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwe"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 내용 중에 숫자가 아닌 값이 있습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
