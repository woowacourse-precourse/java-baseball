package baseball;

import baseball.model.Goal;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Collections;
import java.util.List;
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
    void 예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_다른문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("333"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 상대방_숫자_길이() {
        Goal goal = new Goal();
        goal.setGoalNumber();
        List<Integer> goalNumber = goal.getGoalNumber();

        assertThat(goalNumber.size()).isEqualTo(3);
    }

    @Test
    void 상대방_숫자_중복없는지() {
        Goal goal = new Goal();
        goal.setGoalNumber();
        List<Integer> goalNumber = goal.getGoalNumber();

        int i=0;
        for (Integer goalNumberUnit : goalNumber) {
            i += Collections.frequency(goalNumber,goalNumberUnit);
        }

        assertThat(goalNumber.size()).isEqualTo(3);
    }

    @Test
    void 볼카운트_테스트_스트라이크아웃() {
        Player player = new Player();
        player.setPlayerNumber("123");
        List<Integer> goalNumber = List.of(1,2,3);

        player.ballCount(goalNumber);
        assertThat(player.strikeOut()).isTrue();
    }

    @Test
    void 볼카운트_테스트_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("541", "412", "312", "145", "124", "123", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼", "1스트라이크", "2스트라이크", "3스트라이크");
                },
                1,2,3,1,2,3
        );
    }

    @Test
    void 볼카운트_테스트_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("134", "213", "123", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크");
                },
                1,2,3,1,2,3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
