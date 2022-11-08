package baseball.view;

import static baseball.constant.Constants.*;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("메시지 및 결과 출력 테스트")
public class ViewTest extends NsTest {

    @DisplayName("출력 테스트 1")
    @Test
    void printTest1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "853", "183", "153", "135", "2");
                    assertThat(output()).contains(
                            GAME_START_MESSAGE,
                            NOTHING, "2볼", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크",
                            SUCCESS_MESSAGE, GAME_FINISH_MESSAGE
                    );
                },
                1, 3, 5
        );
    }

    @DisplayName("출력 테스트 2")
    @Test
    void printTest2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("248", "213", "258", "581", "587", "589", "2");
                    assertThat(output()).contains(
                            GAME_START_MESSAGE,
                            "1볼", NOTHING, "2볼", "2스트라이크", "2스트라이크", "3스트라이크",
                            SUCCESS_MESSAGE, GAME_FINISH_MESSAGE
                    );
                },
                5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
