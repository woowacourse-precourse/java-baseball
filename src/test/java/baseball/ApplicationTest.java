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
    class GetGameNumberInstanceByStringCastTest {
        @Test
        void illegalGetGameNumberInstanceByStringTest1() {
            String input = "122";

            assertThatThrownBy(() -> GameNumber.getInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest2() {
            String input = "1234";

            assertThatThrownBy(() -> GameNumber.getInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest3() {
            String input = "91";

            assertThatThrownBy(() -> GameNumber.getInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest4() {
            String input = "102";

            assertThatThrownBy(() -> GameNumber.getInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest5() {
            String input = "112";

            assertThatThrownBy(() -> GameNumber.getInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest6() {
            String input = "1가2";

            assertThatThrownBy(() -> GameNumber.getInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void legalGetGameNumberInstanceByStringTest1() {
            String input = "123";
            int result = 123;
            assertThat(GameNumber.getInstance(input).toInt())
                    .isEqualTo(result);
        }
    }

    @Nested
    class RandomGameNumberGeneratorTest {
        @Test
        void randomGameNumberGeneratorTest1() {
            int result = 154;
            assertRandomNumberInRangeTest(
                    () -> assertThat(GameNumber.getRandomInstance().toInt())
                            .isEqualTo(result),
                    1, 5, 4, 5, 8, 9
            );
        }

        @Test
        void randomGameNumberGeneratorTest2() {
            int result = 158;
            assertRandomNumberInRangeTest(
                    () -> assertThat(GameNumber.getRandomInstance().toInt())
                            .isEqualTo(result),
                    1, 1, 5, 5, 8, 9
            );
        }

        @Test
        void randomGameNumberGeneratorTest3() {
            int result = 158;
            assertRandomNumberInRangeTest(
                    () -> assertThat(GameNumber.getRandomInstance().toInt())
                            .isEqualTo(result),
                    1, 1, 5, 1, 5, 8, 9
            );
        }
    }

    @Nested
    class BallStrikeResultTest {
        @Test
        void oneBallTwoStrikeToStringTest() {
            BallStrikeResult ballStrike = new BallStrikeResult();
            addBallAndStrikeCount(ballStrike, 1, 2);
            String result = "1볼 2스트라이크";
            assertThat(ballStrike.toString()).isEqualTo(result);
        }

        @Test
        void oneBallTwoStrikeDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult();
            addBallAndStrikeCount(ballStrike, 1, 2);
            boolean result = false;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }

        @Test
        void noBallToStringTest() {
            BallStrikeResult ballStrike = new BallStrikeResult();
            addBallAndStrikeCount(ballStrike, 0, 2);
            String result = "2스트라이크";
            assertThat(ballStrike.toString()).isEqualTo(result);
        }

        @Test
        void noBallDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult();
            addBallAndStrikeCount(ballStrike, 0, 2);
            boolean result = false;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }

        @Test
        void noStrikeToStringTest() {
            BallStrikeResult ballStrike = new BallStrikeResult();
            addBallAndStrikeCount(ballStrike, 1, 0);
            String result = "1볼";
            assertThat(ballStrike.toString()).isEqualTo(result);
        }

        @Test
        void noStrikeDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult();
            addBallAndStrikeCount(ballStrike, 1, 0);
            boolean result = false;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }

        @Test
        void nothingToStringTest() {
            BallStrikeResult ballStrike = new BallStrikeResult();
            addBallAndStrikeCount(ballStrike, 0, 0);
            String result = "낫싱";
            assertThat(ballStrike.toString()).isEqualTo(result);
        }

        @Test
        void nothingDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult();
            addBallAndStrikeCount(ballStrike, 0, 0);
            boolean result = false;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }

        @Test
        void threeStrikeDoesWinTest() {
            BallStrikeResult ballStrike = new BallStrikeResult();
            addBallAndStrikeCount(ballStrike, 0, 3);
            boolean result = true;
            assertThat(ballStrike.doesWin()).isEqualTo(result);
        }
    }

    @Nested
    class GameNumberCompareToTest {
        @Test
        void GameNumberCompareToTest1() {
            GameNumber number1 = GameNumber.getInstance("924");
            GameNumber number2 = GameNumber.getInstance("123");

            BallStrikeResult result = new BallStrikeResult();
            addBallAndStrikeCount(result,0, 1);

            assertThat(number1.compareTo(number2)).isEqualTo(result);
        }

        @Test
        void GameNumberCompareToTest2() {
            GameNumber number1 = GameNumber.getInstance("425");
            GameNumber number2 = GameNumber.getInstance("456");

            BallStrikeResult result = new BallStrikeResult();
            addBallAndStrikeCount(result,1, 1);

            assertThat(number1.compareTo(number2)).isEqualTo(result);
        }

        @Test
        void GameNumberCompareToTest3() {
            GameNumber number1 = GameNumber.getInstance("123");
            GameNumber number2 = GameNumber.getInstance("789");

            BallStrikeResult result = new BallStrikeResult();
            addBallAndStrikeCount(result,0, 0);

            assertThat(number1.compareTo(number2)).isEqualTo(result);
        }

        @Test
        void GameNumberCompareToTest4() {
            GameNumber number1 = GameNumber.getInstance("954");
            GameNumber number2 = GameNumber.getInstance("954");

            BallStrikeResult result = new BallStrikeResult();
            addBallAndStrikeCount(result,0, 3);

            assertThat(number1.compareTo(number2)).isEqualTo(result);
        }
    }

    @Nested
    class IsNumericTest {
        @Test
        void isNumericTest1() {
            String input = "11034";
            assertThat(UtilMethods.isNumeric(input)).isEqualTo(true);
        }

        @Test
        void isNumericTest2() {
            String input = "011034";
            assertThat(UtilMethods.isNumeric(input)).isEqualTo(true);
        }

        @Test
        void isNumericTest3() {
            String input = "a11034";
            assertThat(UtilMethods.isNumeric(input)).isEqualTo(false);
        }

        @Test
        void isNumericTest4() {
            String input = "1,1034";
            assertThat(UtilMethods.isNumeric(input)).isEqualTo(false);
        }

        @Test
        void isNumericTest5() {
            String input = "11034a";
            assertThat(UtilMethods.isNumeric(input)).isEqualTo(false);
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

    private void addBallAndStrikeCount(BallStrikeResult ballStrikeResult, int ballCount, int strikeCount) {
        for(int i = 0; i < ballCount; i++) {
            ballStrikeResult.addBallCount();
        }
        for(int i = 0; i < strikeCount; i++) {
            ballStrikeResult.addStrikeCount();
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
