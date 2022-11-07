package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ComputerTest extends NsTest {
    @Test
    void 볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("124", "721", "187", "714", "784", "847", "478", "2");
                    assertThat(output()).contains("1볼", "1볼", "2볼", "2볼", "3볼", "3볼");
                },
                4, 7, 8
        );
    }

    @Test
    void 스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("286", "517","217", "437","237", "2");
                    assertThat(output()).contains("1스트라이크", "1스트라이크", "2스트라이크", "2스트라이크");
                },
                2, 3, 7
        );
    }

    @Test
    void 볼_스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("953", "125", "951", "519", "159", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "2볼 1스트라이크");
                },
                1, 5, 9
        );
    }

    @Test
    void 낫싱_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("124", "187", "784", "478", "123", "569", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "낫싱", "낫싱", "낫싱");
                },
                5, 6, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}