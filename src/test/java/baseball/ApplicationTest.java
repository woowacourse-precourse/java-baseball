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
    void 입력_예외테스트2(){
        assertSimpleTest(()->
                assertThatThrownBy(()-> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class));
    }
    @Test
    void checkBall_함수_테스트1(){
        int index = 0;
        int value = 2;
        List<Integer> computer = new ArrayList<>(Arrays.asList(1,2,3));
        int ballCount = baseball.Application.checkBall(index,value,computer);
        assertThat(ballCount).isEqualTo(1);
    }
    @Test
    void checkBall_함수_테스트2(){
        int index = 0;
        int value = 4;
        List<Integer> computer = new ArrayList<>(Arrays.asList(1,2,3));
        int ballCount = baseball.Application.checkBall(index,value,computer);
        assertThat(ballCount).isEqualTo(0);
    }
    @Test
    void checkStrike_case1(){
        int index = 0;
        int value = 1;
        List<Integer> computer = new ArrayList<>(Arrays.asList(1,2,3));
        int strikeCount = baseball.Application.checkStrike(index,value,computer);
        assertThat(strikeCount).isEqualTo(1);
    }
    @Test
    void checkStrike_case2(){
        int index = 2;
        int value = 1;
        List<Integer> computer = new ArrayList<>(Arrays.asList(1,2,3));
        int strikeCount = baseball.Application.checkStrike(index,value,computer);
        assertThat(strikeCount).isEqualTo(0);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
