package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class ComputerTest extends NsTest {

    @Test
    void 스트라이크_개수_세기() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("146", "138", "135", "2");
                    assertThat(output()).contains("1스트라이크", "1스트라이크", "3스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 볼_개수_세기() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("437", "625", "624", "246", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼");
                },
                2, 4, 6
        );
    }

    @Test
    void 스트라이크와_볼_개수_세기() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("168", "164", "148", "146", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "2볼 1스트라이크", "2스트라이크", "3스트라이크");
                },
                1, 4, 6
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
