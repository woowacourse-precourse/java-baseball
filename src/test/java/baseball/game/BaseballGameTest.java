package baseball.game;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest extends NsTest {

    @DisplayName("야구공 테스트 1")
    @Test
    void 야구공_전체_테스트_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @DisplayName("야구공 테스트 2")
    @Test
    void 야구공_전체_테스트_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "978","987", "1", "597", "654", "2");
                    assertThat(output()).contains("낫싱","2볼 1스트라이크", "3스트라이크", "1볼", "3스트라이크", "게임 종료");
                },
                9,8,7,6,5,4
        );
    }

    @DisplayName("야구공 테스트 3")
    @Test
    void 야구공_전체_테스트_3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "145","671","216","713", "2");
                    assertThat(output()).contains("1볼 1스트라이크","1볼", "2볼", "1스트라이크", "3스트라이크", "게임 종료");
                },
                7,1,3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}