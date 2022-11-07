package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    void 예외_테스트_중복_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_비수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("맹순영"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산_테스트1() {
        List<Integer> answer = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        List<Integer> ballAndStrikeList = Application.calculate(answer, "123");
        assertThat(ballAndStrikeList.get(1)).isEqualTo(3);
    }

    @Test
    void 계산_테스트2() {
        List<Integer> answer = new ArrayList<>(
                Arrays.asList(1,2,5)
        );
        List<Integer> ballAndStrikeList = Application.calculate(answer, "123");
        assertThat(ballAndStrikeList.get(0)).isEqualTo(0);
        assertThat(ballAndStrikeList.get(1)).isEqualTo(2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
