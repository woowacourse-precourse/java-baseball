package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

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
    void 게임즉시종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("156","381", "397", "937", "379", "2");
                    assertThat(output()).contains("낫싱", "1스트라이크", "2볼 1스트라이크", "3볼", "3스트라이크", "게임 종료");
                },
                3, 7, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
