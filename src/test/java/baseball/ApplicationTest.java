package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 출력_테스트(){
        assertThat(Application.output(0,2)).isEqualTo("2볼");
        assertThat(Application.output(1,0)).isEqualTo("1스트라이크");
        assertThat(Application.output(1,2)).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 볼_체크_테스트(){
        List<Integer> inputNum=new ArrayList<Integer>();
        inputNum.add(7);
        inputNum.add(1);
        inputNum.add(3);

        assertThat(Application.checkBallNum(3,0,inputNum)).isEqualTo(true);
        assertThat(Application.checkBallNum(1,2,inputNum)).isEqualTo(true);
        assertThat(Application.checkBallNum(7,0,inputNum)).isEqualTo(false);
        assertThat(Application.checkBallNum(9,0,inputNum)).isEqualTo(false);
    }

    @Test
    void 볼_개수_테스트(){
        List<Integer> randomNum=new ArrayList<Integer>();
        randomNum.add(7);
        randomNum.add(1);
        randomNum.add(3);

        List<Integer> inputNum1=new ArrayList<Integer>();
        inputNum1.add(1);
        inputNum1.add(3);
        inputNum1.add(5);

        assertThat(Application.checkBall(randomNum,inputNum1)).isEqualTo(2);

        List<Integer> inputNum2=new ArrayList<Integer>();
        inputNum2.add(7);
        inputNum2.add(3);
        inputNum2.add(5);

        assertThat(Application.checkBall(randomNum,inputNum2)).isEqualTo(1);
    }

    @Test
    void 스트라이크_개수_테스트(){
        List<Integer> randomNum=new ArrayList<Integer>();
        randomNum.add(7);
        randomNum.add(1);
        randomNum.add(3);

        List<Integer> inputNum1=new ArrayList<Integer>();
        inputNum1.add(7);
        inputNum1.add(3);
        inputNum1.add(5);

        List<Integer> inputNum2=new ArrayList<Integer>();
        inputNum2.add(7);
        inputNum2.add(1);
        inputNum2.add(3);

        assertThat(Application.checkStrike(randomNum,inputNum1)).isEqualTo(1);
        assertThat(Application.checkStrike(randomNum,inputNum2)).isEqualTo(3);
    }

    @Test
    void 스트라이크_볼_개수로_판단_테스트(){
        List<Integer> randomNum=new ArrayList<Integer>();
        randomNum.add(7);
        randomNum.add(1);
        randomNum.add(3);

        List<Integer> inputNum1=new ArrayList<Integer>();
        inputNum1.add(7);
        inputNum1.add(1);
        inputNum1.add(3);

        List<Integer> inputNum2=new ArrayList<Integer>();
        inputNum2.add(8);
        inputNum2.add(5);
        inputNum2.add(2);

        List<Integer> inputNum3=new ArrayList<Integer>();
        inputNum3.add(7);
        inputNum3.add(3);
        inputNum3.add(8);

        assertThat(Application.checkNum(randomNum,inputNum1)).isEqualTo(true);
        assertThat(Application.checkNum(randomNum,inputNum2)).isEqualTo(false);
        assertThat(Application.checkNum(randomNum,inputNum3)).isEqualTo(false);
    }

    @Test
    void 입력_예외처리_테스트(){
        assertThatThrownBy(() -> Application.exception("12"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.exception("12583"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.exception("102"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.exception("12r"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.exception("!Rㄱ"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.exception("112"))
                .isInstanceOf(IllegalArgumentException.class);
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
