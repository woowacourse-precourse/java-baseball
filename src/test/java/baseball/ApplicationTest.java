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
    void 정수가_아닌_경우_예외_테스트() {
        String input = "Q12";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영이_포함된_경우_예외_테스트() {
        String input = "302";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복이_있는_경우_예외_테스트() {
        String input = "447";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음의_정수가_있는_경우_예외_테스트() {
        String input = "4-47";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
