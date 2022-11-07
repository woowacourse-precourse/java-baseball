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
    void 스트라이크_테스트(){
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> user = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(Application.strike(computer,user)).isEqualTo(3);
    }

    @Test
    void 볼_테스트(){
        List<Integer> computer = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<Integer> user = new ArrayList<>(Arrays.asList(1, 2, 3));
        int strike = 1;
        assertThat(Application.ball(computer, user, strike)).isEqualTo(2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
