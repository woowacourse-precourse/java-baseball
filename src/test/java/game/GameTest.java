package game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

class GameTest extends NsTest {

    @Test
    void 게임_정상_종료_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "123", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 게임_재실행_후_정상_종료_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "123", "1", "654", "456", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "3스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3, 4, 5, 6
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}