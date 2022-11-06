package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Nested
    class IntToTargetNumberCastTest {
        @Test
        void illegalIntToTargetNumberCastTest1() {
            int input = 122;

            assertThatThrownBy(() -> new TargetNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalIntToTargetNumberCastTest2() {
            int input = 1234;

            assertThatThrownBy(() -> new TargetNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalIntToTargetNumberCastTest3() {
            int input = 91;

            assertThatThrownBy(() -> new TargetNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalIntToTargetNumberCastTest4() {
            int input = 102;

            assertThatThrownBy(() -> new TargetNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalIntToTargetNumberCastTest5() {
            int input = 112;

            assertThatThrownBy(() -> new TargetNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void legalIntToTargetNumberCastTest1() {
            int input = 123;
            int result = 123;
            assertThat(new TargetNumber(input).toInt())
                    .isEqualTo(result);
        }
    }

    @Nested
    class RandomTargetNumberGeneratorTest {
        @Test
        void randomTargetNumberGeneratorTest1() {
            int result = 154;
            assertRandomNumberInRangeTest(
                    () -> assertThat(TargetNumber.getRandomInstance().toInt())
                            .isEqualTo(result),
                    1, 5, 4, 5, 8, 9
            );
        }

        @Test
        void randomTargetNumberGeneratorTest2() {
            int result = 158;
            assertRandomNumberInRangeTest(
                    () -> assertThat(TargetNumber.getRandomInstance().toInt())
                            .isEqualTo(result),
                    1, 1, 5, 5, 8, 9
            );
        }

        @Test
        void randomTargetNumberGeneratorTest3() {
            int result = 158;
            assertRandomNumberInRangeTest(
                    () -> assertThat(TargetNumber.getRandomInstance().toInt())
                            .isEqualTo(result),
                    1, 1, 5, 1, 5, 8, 9
            );
        }
    }

    @Nested
    class BallStrikeResultTest {
        @Test
        void oneBallTwoStrikeToStringTest() {
            BallStrikeResult ballStrike = new BallStrikeResult(1, 2);
            String result = "1볼 2스트라이크";
            assertThat(ballStrike.toString()).isEqualTo(result);
        }

        @Test
        void oneBallTwoStrikeDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult(1, 2);
            boolean result = false;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }

        @Test
        void noBallToStringTest() {
            BallStrikeResult ballStrike = new BallStrikeResult(0, 2);
            String result = "2스트라이크";
            assertThat(ballStrike.toString()).isEqualTo(result);
        }

        @Test
        void noBallDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult(0, 2);
            boolean result = false;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }

        @Test
        void noStrikeToStringTest() {
            BallStrikeResult ballStrike = new BallStrikeResult(1, 0);
            String result = "1볼";
            assertThat(ballStrike.toString()).isEqualTo(result);
        }

        @Test
        void noStrikeDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult(1, 0);
            boolean result = false;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }

        @Test
        void nothingToStringTest() {
            BallStrikeResult ballStrike = new BallStrikeResult(0, 0);
            String result = "낫싱";
            assertThat(ballStrike.toString()).isEqualTo(result);
        }

        @Test
        void nothingDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult(1, 2);
            boolean result = false;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }

        @Test
        void threeStrikeDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult(1, 2);
            boolean result = true;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }
    }

    @Nested
    class TargetNumberCompareToTest {
        @Test
        void targetNumberCompareToTest1() {
            TargetNumber number1 = new TargetNumber(924);
            TargetNumber number2 = new TargetNumber(123);
            BallStrikeResult result = new BallStrikeResult(0, 1);
            assertThat(number1.compareTo(number2)).isEqualTo(result);
        }

        @Test
        void targetNumberCompareToTest2() {
            TargetNumber number1 = new TargetNumber(425);
            TargetNumber number2 = new TargetNumber(456);
            BallStrikeResult result = new BallStrikeResult(1, 1);
            assertThat(number1.compareTo(number2)).isEqualTo(result);
        }

        @Test
        void targetNumberCompareToTest3() {
            TargetNumber number1 = new TargetNumber(123);
            TargetNumber number2 = new TargetNumber(789);
            BallStrikeResult result = new BallStrikeResult(0, 0);
            assertThat(number1.compareTo(number2)).isEqualTo(result);
        }

        @Test
        void targetNumberCompareToTest4() {
            TargetNumber number1 = new TargetNumber(954);
            TargetNumber number2 = new TargetNumber(954);
            BallStrikeResult result = new BallStrikeResult(0, 3);
            assertThat(number1.compareTo(number2)).isEqualTo(result);
        }
    }

    @Nested
    class GameRepeatTest {
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
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
