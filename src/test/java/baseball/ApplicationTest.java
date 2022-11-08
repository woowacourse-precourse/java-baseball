package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void validate_예외_테스트1() {
        assertThatThrownBy(() -> Application.validate(5))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getGameResult_테스트1() {
        assertThat(Application.getGameResult(123, 123)).isEqualTo(List.of(0, 3));
    }

    @Test
    void getGameResult_테스트2() {
        assertThat(Application.getGameResult(542, 425)).isEqualTo(List.of(3, 0));
    }

    @Test
    void getGameResult_테스트3() {
        assertThat(Application.getGameResult(145, 167)).isEqualTo(List.of(0, 1));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
