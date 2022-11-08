package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.participants.Hitter;
import baseball.participants.Pitcher;
import baseball.participants.Referee;
import baseball.participants.SportsCaster;
import baseball.participants.StrikeZone;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2"); // 값을 하나씩 입력하면서 게임 진행
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크",
                            "게임 종료"); // outputStream 값들 테스트
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    class PitcherInputTest extends NsTest {
        @Test
        void testPitch() {
            run("245");
            assertThat(output()).contains("3자리 숫자를 입력해주세요 :", "245");
        }

        @Override
        protected void runMain() {
            Pitcher pitcher = new Pitcher();
            pitcher.pitch();
            System.out.println(pitcher.pitchZone.toString());
        }
    }

    @Nested
    class RefereeJudgeTest extends NsTest {
        @Test
        void strike1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("234");
                        assertThat(output()).contains("1스트라이크");
                    },
                    2, 2, 2
            );
        }

        @Test
        void ball1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("262");
                        assertThat(output()).contains("1볼");
                    },
                    3, 2, 4
            );
        }

        @Test
        void ball1Strike1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("252");
                        assertThat(output()).contains("1볼 1스트라이크");
                    },
                    2, 2, 4
            );
        }

        @Test
        void strike2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("262");
                        assertThat(output()).contains("2스트라이크");
                    },
                    2, 3, 2
            );
        }

        @Test
        void ball2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123");
                        assertThat(output()).contains("2볼");
                    },
                    2, 3, 2
            );
        }

        @Test
        void ball2_2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("232");
                        assertThat(output()).contains("2볼");
                    },
                    1, 2, 3
            );
        }

        @Test
        void ball2Strike1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("233");
                        assertThat(output()).contains("2볼 1스트라이크");
                    },
                    3, 3, 2
            );
        }

        @Test
        void ball3() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("561");
                        assertThat(output()).contains("3볼");
                    },
                    1, 5, 6
            );
        }

        @Test
        void strike3() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("232");
                        assertThat(output()).contains("3스트라이크");
                    },
                    2, 3, 2
            );
        }

        @Test
        void nothing() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("561");
                        assertThat(output()).contains("낫싱");
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

    @Nested
    class SportsCasterTest extends NsTest {
        @Test
        void testPlayAgain() {
            run("4", "1");
            assertThat(output()).contains("1 혹은 2만 입력해주세요.", "게임을 다시 시작합니다.");
        }

        @Test
        void testTerminateGame() {
            run("4", "2");
            assertThat(output()).contains("1 혹은 2만 입력해주세요.", "게임을 완전히 종료합니다.");
        }

        @Override
        protected void runMain() {
            SportsCaster sportsCaster = new SportsCaster();
            sportsCaster.askToPlayAgain();
        }
    }

    @Nested
    class StrikeZoneTest {
        @Test
        void String1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone("1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void String2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone("12"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void String4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void intList1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone(List.of(1)))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void intList2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone(List.of(1, 2)))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void intList4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone(List.of(1, 2, 3, 4)))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}
