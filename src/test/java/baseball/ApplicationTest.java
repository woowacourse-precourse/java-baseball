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
    void 비교결과_테스트() {
        String input = "123";
        List<Integer> computer = List.of(2, 9, 3);
        List<Integer> result = List.of(1, 1);
        assertThat(Game.compareWithComputer(input, computer)).isEqualTo(result);
    }

    @Test
    void 비교결과출력_테스트() {
        List<Integer> compareResult = List.of(1, 1);
        String result = "1볼 1스트라이크";
        assertThat(Game.resultToString(compareResult)).isEqualTo(result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
