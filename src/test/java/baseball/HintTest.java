package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class HintTest extends NsTest {
    @Test
    void 볼() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("513", "413", "241", "135", "2");
                    assertThat(output()).contains( "3볼", "2볼", "1볼");
                },
                1, 3, 5
        );
    }


    @Test
    void 볼스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("157", "315", "135", "2");
                    assertThat(output()).contains( "1볼 1스트라이크", "2볼 1스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("178", "139", "135", "2");
                    assertThat(output()).contains( "1스트라이크", "2스트라이크", "3스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 낫싱() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("789", "826", "135", "2");
                    assertThat(output()).contains( "낫싱");
                },
                1, 3, 5
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
