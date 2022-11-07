package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest extends NsTest {
    @Test
    void 게임종료_후_재시작_예외 () {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "9"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("1 혹은 2 이외의 문자를 입력 하셨습니다.");
                },
                1, 2, 3
        );

        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "@"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("1 혹은 2 이외의 문자를 입력 하셨습니다.");
                },
                1, 2, 3
        );

        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "123"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("한 자리를 초과하는 문자를 입력하셨습니다.");
                },
                1, 2, 3
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
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 숫자가 세 자리가 아닙니다.")
        );
    }

    @Test
    void 입력이_1부터_9사이의_숫자가_아닌경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("q12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 내용 중에 숫자가 아니거나, 0인 값이 있습니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwe"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 내용 중에 숫자가 아니거나, 0인 값이 있습니다.")
        );
    }

    @Test
    void 같은_숫자를_입력한경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 내용 중에 중복되는 숫자가 있습니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("333"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력하신 내용 중에 중복되는 숫자가 있습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
