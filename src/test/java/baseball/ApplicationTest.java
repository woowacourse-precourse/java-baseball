package baseball;

import baseball.service.GameService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 랜덤수_중복유무_체크() {
        List<Integer> randomballs;
        boolean doublecheck = true;
        randomballs = GameService.makeRandomBall();

        if (randomballs.get(0).equals(randomballs.get(1))) doublecheck = false;
        if (randomballs.get(1).equals(randomballs.get(2))) doublecheck = false;
        if (randomballs.get(0).equals(randomballs.get(2))) doublecheck = false;

        assertThat(true).isEqualTo(doublecheck);
    }
    @Test
    void 랜덤수_자릿수_체크() {
        int checkindex = 0;
        List<Integer> checksize;
        checksize = GameService.makeRandomBall();

        for(int i : checksize) {
            checkindex++;
        }
        assertThat(checksize.size()).isEqualTo(checkindex);
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
