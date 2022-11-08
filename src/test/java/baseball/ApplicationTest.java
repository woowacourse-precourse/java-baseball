package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @Test
    void 낫싱(){
        List<Integer> userInput = Arrays.asList(1,2,3);
        List<Integer> computer = Arrays.asList(3,5,6);

        Boolean isNothing = isNothing(userInput,computer);
        assertThat(isNothing).isEqualTo(false);
    }

    @Test
    void 스트라이크(){
        List<Integer> userInput = Arrays.asList(1,2,3);
        List<Integer> computer = Arrays.asList(2,5,3);

        int strike = numberOfStrikes(userInput,computer);
        int result = 1;

        assertThat(strike).isEqualTo(result);
    }

    @Test
    void 볼(){
        List<Integer> userInput = Arrays.asList(1,2,3);
        List<Integer> computer = Arrays.asList(2,5,1);

        int ball = numberOfBalls(userInput,computer);
        int result = 2;

        assertThat(ball).isEqualTo(result);
    }

    @Test
    void 숫자야구_시도_결과_출력(){

        int strike = 2;
        int ball = 0;

        String result = "2스트라이크";
        printResult(strike,ball);
        assertThat(output()).isEqualTo(result);
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
