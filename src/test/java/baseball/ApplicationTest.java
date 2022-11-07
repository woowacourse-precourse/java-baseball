package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.util.List;

import static baseball.domain.Computer.randomNum;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private List<Integer> num = randomNum();
    @Test
    void 랜덤_숫자_길이_테스트() {
        int len = randomNum().size();
        assertThat(len).isEqualTo(3);
    }

    private boolean setUp(){
        if(num.get(0) == num.get(1) || num.get(0) == num.get(2) || num.get(1) == num.get(2)){
            return false;
        }

        return true;
    }
    @Test
    void 랜덤_숫자_중복_테스트(){
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
        Application.main(new String[]{});
    }
}
