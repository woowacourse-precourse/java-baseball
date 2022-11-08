package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static baseball.Application.*;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void getStrikeAndBallTest() {
        List<String> computer = Arrays.asList("987", "123");
        List<String> user = Arrays.asList("987", "321");
        int[][] results = {{3, 0}, {1, 2}};
        for (int iter = 0; iter < 2; iter++) {
            assertThat(getStrikeAndBall(computer.get(iter), user.get(iter)).equals(results[iter]));
        }
    }
}
