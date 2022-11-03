package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    void 입력_검증_글자수_부족_예외(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.validateUserInput("97"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력_검증_숫자_외_문자입력_예외(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.validateUserInput("9x7"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 스트라이크_테스트(){
        List<Integer> computer = Arrays.asList(3,8,7);
        Integer strike = 0;

        strike = Application.checkStrike(computer,"387");
        assertThat(strike).isEqualTo(3);
    }

    @Test
    void 볼_테스트() {
        HashMap<Integer, Integer> computerIndexMap = new HashMap<>();
        Integer ball = 0;

        computerIndexMap.put(3,0);
        computerIndexMap.put(8,1);
        computerIndexMap.put(7,2);

        ball = Application.checkBall(computerIndexMap,"738");
        assertThat(ball).isEqualTo(3);

        ball = Application.checkBall(computerIndexMap,"748");
        assertThat(ball).isEqualTo(2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
