package baseball;

import baseball.participants.Hitter;
import baseball.participants.Pitcher;
import baseball.participants.Referee;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RefereeJudgeTest extends NsTest {
    @Test
    void strike1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("234");
                    assertThat(output()).isEqualTo("1스트라이크");
                },
                2, 2, 2
        );
    }

    @Test
    void ball1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("262");
                    assertThat(output()).isEqualTo("1볼");
                },
                3, 2, 4
        );
    }

    @Test
    void ball1Strike1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("252");
                    assertThat(output()).isEqualTo("1볼 1스트라이크");
                },
                2, 2, 4
        );
    }

    @Test
    void strike2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("262");
                    assertThat(output()).isEqualTo("2스트라이크");
                },
                2, 3, 2
        );
    }

    @Test
    void ball2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123");
                    assertThat(output()).isEqualTo("2볼");
                },
                2, 3, 2
        );
    }

    @Test
    void ball2_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("232");
                    assertThat(output()).isEqualTo("2볼");
                },
                1, 2, 3
        );
    }

    @Test
    void ball2Strike1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("233");
                    assertThat(output()).isEqualTo("2볼 1스트라이크");
                },
                3, 3, 2
        );
    }

    @Test
    void ball3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("561");
                    assertThat(output()).isEqualTo("3볼");
                },
                1, 5, 6
        );
    }

    @Test
    void strike3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("232");
                    assertThat(output()).isEqualTo("3스트라이크");
                },
                2, 3, 2
        );
    }

    @Test
    void nothing() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("561");
                    assertThat(output()).isEqualTo("낫싱");
                },
                2, 3, 2
        );
    }

    @Override
    protected void runMain() {
        Referee referee = new Referee();
        Hitter hitter = new Hitter();
        Pitcher pitcher = new Pitcher();
        hitter.swing();
        pitcher.pitch();
        referee.judge(pitcher.pitchZone, hitter.swingZone);
    }
}
