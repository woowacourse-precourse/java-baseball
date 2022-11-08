package baseball;

import baseball.model.Goal;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
