package baseball;

import baseball.global.constants.Constants.Korean;
import baseball.utils.TestUtils;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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

    @Test
    @DisplayName("게임 Start Message")
    @Disabled
    void printGameStartMessage_Test() {
        // given
        ByteArrayOutputStream output = TestUtils.setOutToByteArray();

        // when
//        Application.printGameStartMessage();

        // then
        String printResult = output.toString().trim();
        assertThat(printResult).isEqualTo(Korean.GAME_START_MESSAGE);
        TestUtils.clearSetOutToByteArray(output);
    }
}
