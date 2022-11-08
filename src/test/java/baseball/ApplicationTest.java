package baseball;

import baseball.model.BallStrikeResult;
import baseball.model.GameNumber;
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

            assertThatThrownBy(() -> GameNumber.makeInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest2() {
            String input = "1234";

            assertThatThrownBy(() -> GameNumber.makeInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest3() {
            String input = "91";

            assertThatThrownBy(() -> GameNumber.makeInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest4() {
            String input = "102";

            assertThatThrownBy(() -> GameNumber.makeInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest5() {
            String input = "112";

            assertThatThrownBy(() -> GameNumber.makeInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void illegalGetGameNumberInstanceByStringTest6() {
            String input = "1가2";

            assertThatThrownBy(() -> GameNumber.makeInstance(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void legalGetGameNumberInstanceByStringTest1() {
            String input = "123";
            String  result = "123";
            assertThat(GameNumber.makeInstance(input).toString())
                    .isEqualTo(result);
        }
    }

    @Nested
    class RandomGameNumberGeneratorTest {
        @Test
        void randomGameNumberGeneratorTest1() {
            String  result = "154";
            assertRandomNumberInRangeTest(
                    () -> assertThat(GameNumber.makeRandomInstance().toString())
                            .isEqualTo(result),
                    1, 5, 4, 5, 8, 9
            );
        }

        @Test
        void randomGameNumberGeneratorTest2() {
            String result = "158";
            assertRandomNumberInRangeTest(
                    () -> assertThat(GameNumber.makeRandomInstance().toString())
                            .isEqualTo(result),
                    1, 1, 5, 5, 8, 9
            );
        }

        @Test
        void randomGameNumberGeneratorTest3() {
            String result = "158";
            assertRandomNumberInRangeTest(
                    () -> assertThat(GameNumber.makeRandomInstance().toString())
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
            GameNumber number1 = GameNumber.makeInstance("924");
            GameNumber number2 = GameNumber.makeInstance("123");

            BallStrikeResult result = new BallStrikeResult();
            addBallAndStrikeCount(result,0, 1);

            assertThat(number1.countBallStrike(number2)).isEqualTo(result);
        }

        @Test
        void GameNumberCompareToTest2() {
            GameNumber number1 = GameNumber.makeInstance("425");
            GameNumber number2 = GameNumber.makeInstance("456");

            BallStrikeResult result = new BallStrikeResult();
            addBallAndStrikeCount(result,1, 1);

            assertThat(number1.countBallStrike(number2)).isEqualTo(result);
        }

        @Test
        void GameNumberCompareToTest3() {
            GameNumber number1 = GameNumber.makeInstance("123");
            GameNumber number2 = GameNumber.makeInstance("789");

            BallStrikeResult result = new BallStrikeResult();
            addBallAndStrikeCount(result,0, 0);

            assertThat(number1.countBallStrike(number2)).isEqualTo(result);
        }

        @Test
        void GameNumberCompareToTest4() {
            GameNumber number1 = GameNumber.makeInstance("954");
            GameNumber number2 = GameNumber.makeInstance("954");

            BallStrikeResult result = new BallStrikeResult();
            addBallAndStrikeCount(result,0, 3);

            assertThat(number1.countBallStrike(number2)).isEqualTo(result);
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
