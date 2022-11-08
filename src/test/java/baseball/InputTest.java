package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {

    @Test
    void 사용자의_야구숫자_입력값이_1에서_9사이_값이_아닌_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("013"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 사용자의_야구숫자_입력값의_길이가_3이_아닌_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("452453"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 사용자의_야구숫자_입력값에_중복이_있을_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111", "222"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 게임_종료_후_사용자의_입력값이_1_또는_2가_아닌_경우_예외_발생() {
        assertRandomNumberInRangeTest(() ->
                assertThatThrownBy(() -> runException("246", "4"))
                        .isInstanceOf(IllegalArgumentException.class),
                2, 4, 6
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
