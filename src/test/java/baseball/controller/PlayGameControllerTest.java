package baseball.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static baseball.config.Config.playGameController;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class PlayGameControllerTest extends NsTest {

    @Test
    void 게임_컨트롤러_실행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "123", "1", "416", "456", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3, 4, 5, 6
        );
    }

    @Override
    protected void runMain() {
        playGameController().run();
    }
}