package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static baseball.Game.game;
import static baseball.RandomNum.randomNum;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private int[] num = randomNum();

    @Test
    void 랜덤_숫자_길이_테스트() {
        int len = randomNum().length;
        assertThat(len).isEqualTo(3);
    }


    private boolean setUp(){
        if(num[0] == num[1] || num[0] == num[2] || num[1] == num[2]){
            return false;
        }
        return true;
    }
    @Test
    void 숫자_중복_테스트(){
        assertThat(setUp()).isEqualTo(true);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
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

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
