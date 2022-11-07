package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 스트라이크_개수_반환(){
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);

        List<Integer> user = new ArrayList<>();
        user.add(1);
        user.add(5);
        user.add(3);

        assertThat(countStrike(computer, user)).isEqualTo(2);
    }

    @Test
    void 볼_개수_반환(){
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);

        List<Integer> user = new ArrayList<>();
        user.add(1);
        user.add(5);
        user.add(3);

        assertThat(countBall(computer, user)).isEqualTo(0);
    }

    @Test
    void 정답인지_체크(){
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);

        List<Integer> user = new ArrayList<>();
        user.add(1);
        user.add(5);
        user.add(3);

        boolean result = compare(computer, user);
        assertThat(result).isEqualTo(false);

        List<Integer> computer2 = new ArrayList<>();
        computer2.add(1);
        computer2.add(2);
        computer2.add(3);

        List<Integer> user2 = new ArrayList<>();
        user2.add(1);
        user2.add(2);
        user2.add(3);

        result = compare(computer2, user2);
        assertThat(result).isEqualTo(true);
    }

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
}
