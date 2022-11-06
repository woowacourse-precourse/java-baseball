package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    BaseBallGame baseBallGame = BaseBallGame.getGame();

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
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 힌트함수_테스트1() {
        int inputNum = 123;
        int comNum = 213;
        List<Integer> hint = baseBallGame.getHint(inputNum, comNum);
        int ball = hint.get(0);
        int strike = hint.get(1);
        assertThat(ball).isEqualTo(2);
        assertThat(strike).isEqualTo(1);

    }

    @Test
    void 랜덤숫자_테스트1() {
        int exceptCnt = 0;
        for (int i = 0; i < 100; i++) {
            String randomNum = Integer.toString(baseBallGame.getRandomDiff3DigitNumber());
            if (randomNum.charAt(0) == randomNum.charAt(1)
                    || randomNum.charAt(1) == randomNum.charAt(2)
                    || randomNum.charAt(0) == randomNum.charAt(2)
            ) {
                exceptCnt++;
            }
        }
        assertThat(exceptCnt).isEqualTo(0);
    }

//    @Test
//    void 풀이함수_테스트1() {
//        BaseBallGame baseBallGame = BaseBallGame.getGame();
//        baseBallGame.solvingProblem(333);
//    }

    @Test
    void 입력값_중복체크_테스트1(){
        boolean isPure = baseBallGame.isDiffDigitNumber("123");
        assertThat(isPure).isEqualTo(true);
    }

    @Test
    void 입력값_중복체크_테스트2(){
        boolean isPure = baseBallGame.isDiffDigitNumber("223");
        assertThat(isPure).isEqualTo(false);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
