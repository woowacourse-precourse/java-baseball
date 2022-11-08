package baseball;

import baseball.Model.Balls;
import baseball.Model.Computer;
import baseball.Model.Player;
import baseball.View.Message;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    /**
     * assertRandomNumberInRangeTest 를 활용해서 컴퓨터 랜덤 숫자 값을 지정한다. (1, 3, 5) , (5, 8, 9)
     * run 으로 프로그램을 시작하고, ("246", "135", "1", "597", "589", "2") 순으로 입력을 제공한다.
     * assertThat 을 사용해서 output(출력값)이 ("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료") 로 나오는지 검증한다.
     */
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


    /**
     * assertSimpleTest 를 활용해서 테스트가 1초 이내에 가능한지 파악한다.
     * assertThatThrownBy 로 예외가 터질 상황을 만들고, 터진 예외가 IllegalArgumentException 인지 , 1초 이내였는지 확인한다.
     */
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임_결과_1스트라이크_테스트() {
        Computer computer = new Computer();
        computer.answer.balls = Arrays.asList(4,2,5);

        Balls guess = new Balls();
        guess.balls = Arrays.asList(1,2,3);
        computer.judge(guess);
        assertThat("1스트라이크").isEqualTo(output());
    }

    @Test
    void 게임_결과_1볼_1스트라이크_테스트() {
        Computer computer = new Computer();
        computer.answer.balls = Arrays.asList(4,2,5);

        Balls guess = new Balls();
        guess.balls = Arrays.asList(4,5,6);
        computer.judge(guess);
        assertThat("1볼 1스트라이크").isEqualTo(output());
    }

    @Test
    void 게임_결과_낫싱_테스트() {
        Computer computer = new Computer();
        computer.answer.balls = Arrays.asList(4,2,5);

        Balls guess = new Balls();
        guess.balls = Arrays.asList(7,8,9);
        computer.judge(guess);
        assertThat("낫싱").isEqualTo(output());
    }


    /**
     * main application 을 수행한다.
     */
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
