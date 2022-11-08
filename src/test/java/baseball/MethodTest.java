package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.*;


import static baseball.Application.*;
import static org.assertj.core.api.Assertions.*;

public class MethodTest extends NsTest {


    @Test
    void 랜덤_숫자_생성테스트(){
        ArrayList<Integer> computer = new ArrayList<>();
        randomComputer(computer);
        int result = 3;
        assertThat(randomComputer(computer).size()).isEqualTo(result);

    }
    @Test
    void 볼_판별(){
        ArrayList<Integer> computer = new ArrayList<Integer>(Arrays.asList(1,3,2));
        String user = "123";
        int ball = calculateBall(computer,user);
        int result = 2;
        assertThat(ball).isEqualTo(result);
    }
    @Test
    void 스트라이크_판별(){
        ArrayList<Integer> computer = new ArrayList<Integer>(Arrays.asList(6,5,4));
        String user = "654";
        int strike = calculateStrike(computer,user);
        int result = 3;
        assertThat(strike).isEqualTo(result);
    }
    @Test
    void 출력테스트(){
        String Msg = "2볼 1스트라이크";
        int ball =2;
        int strike=1;
        printResult(ball,strike);
        assertThat(output()).isEqualTo(Msg);
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

