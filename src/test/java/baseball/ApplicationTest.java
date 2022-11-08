package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.LetsPlayBall.*;
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
    void Strike(){
        List<Integer> userNum = Arrays.asList(1,2,3);
        List<Integer> comNum = Arrays.asList(1,2,3);

        int strike = strikeCount(userNum,comNum);
        int result = 1;

        assertThat(strike).isEqualTo(result);
    }
    void Ball(){
        List<Integer> userNum = Arrays.asList(1,2,3);
        List<Integer> comNum = Arrays.asList(2,4,1);

        int ball = ballCount(userNum,comNum);
        int result = 2;

        assertThat(ball).isEqualTo(result);
    }
    @Test
    void Noting() {
        List<Integer> userNum = Arrays.asList(1,2,3);
        List<Integer> comNum = Arrays.asList(4,5,6);

        Boolean Nothing;
        Nothing = nothingCount(userNum, comNum);
        assertThat(Nothing).isEqualTo(false);
    }
}
