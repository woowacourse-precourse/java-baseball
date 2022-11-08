package baseball.controller;

import baseball.config.AppConfig;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameControllerTest extends NsTest {

    private BaseballGameController baseballGameController;

    @BeforeEach
    void setUp() {
        baseballGameController = AppConfig.baseballGameController();
    }

    @Test
    void 2입력시_게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                4, 5, 6
        );
    }

    @Test
    void 1입력시_() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "1", "213", "123", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "2볼 1스트라이크", "게임 종료");
                },
                4, 5, 6, 1, 2, 3
        );
    }

    @Override
    protected void runMain() {
        baseballGameController.run();
    }
}
