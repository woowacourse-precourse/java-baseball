package computer;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ComputerTest extends NsTest {

    @Test
    void 낫싱_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "476", "135", "2");
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("136", "436", "135", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("513", "523", "135", "2");
                    assertThat(output()).contains("3볼", "2볼");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크_볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("153", "431", "135", "2");
                    assertThat(output()).contains("2볼 1스트라이크", "1볼 1스트라이크");
                },
                1, 3, 5
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
