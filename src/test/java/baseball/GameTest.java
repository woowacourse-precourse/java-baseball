package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("235", "236", "234", "1", "612", "162", "362", "562", "567", "2");
                    assertThat(output()).contains("2스트라이크", "2스트라이크", "3스트라이크", "1볼",
                            "1스트라이크", "1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                2, 3, 4, 5, 6, 7
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
