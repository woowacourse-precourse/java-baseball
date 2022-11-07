package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Nested
    class getResultTest {

        @Test
        void caseNothing() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            String resultNothing = computer.getResult("456");
            assertEquals("낫싱", resultNothing);
        }

        @Test
        void caseBall() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            String resultBall = computer.getResult("345");
            assertEquals("1볼", resultBall);
        }

        @Test
        void caseStrike() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            String resultStrike = computer.getResult("148");
            assertEquals("1스트라이크", resultStrike);
        }

        @Test
        void caseBallStrike() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            String resultBallStrike = computer.getResult("321");
            assertEquals("2볼 1스트라이크", resultBallStrike);
        }

        @Test
        void caseGameOver() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            String resultGameOver = computer.getResult("123");
            assertEquals("3스트라이크\n"
                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료", resultGameOver);
        }
    }

    @Nested
    class isNothingTest {

        @Test
        void caseNothing() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            boolean resultNothing = computer.isNothing("456");
            assertTrue(resultNothing);
        }

        @Test
        void caseNotNothing() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            boolean resultNotNothing = computer.isNothing("345");
            assertFalse(resultNotNothing);
        }
    }

    @Nested
    class isStrikeTest {

        @Test
        void caseStrike() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            boolean resultStrike = computer.isStrike(1, 0);
            ;
            assertTrue(resultStrike);
        }

        @Test
        void caseNotStrike() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            boolean resultNotStrike = computer.isStrike(2, 2);
            ;
            assertFalse(resultNotStrike);
        }
    }

    @Nested
    class isBallTest {

        @Test
        void caseBall() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            boolean resultBall = computer.isBall(2, 0);
            assertTrue(resultBall);
        }

        @Test
        void caseNotBall() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            boolean resultNotBall = computer.isBall(2, 1);
            assertFalse(resultNotBall);
        }
    }

    @Nested
    class getStrikeCountTest {

        @Test
        void caseZeroStrike() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            int resultZeroStrike = computer.getStrikeCount("231");
            assertEquals(0, resultZeroStrike);
        }

        @Test
        void caseOneStrike() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            int resultOneStrike = computer.getStrikeCount("168");
            assertEquals(1, resultOneStrike);
        }

        @Test
        void caseTwoStrike() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            int resultTwoStrike = computer.getStrikeCount("623");
            assertEquals(2, resultTwoStrike);
        }

        @Test
        void caseThreeStrike() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            int resultThreeStrike = computer.getStrikeCount("123");
            assertEquals(3, resultThreeStrike);
        }
    }

    @Nested
    class getBallCountTest {

        @Test
        void caseZeroBall() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            int resultZeroBall = computer.getBallCount("145");
            assertEquals(0, resultZeroBall);
        }

        @Test
        void caseOneBall() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            int resultOneBall = computer.getBallCount("325");
            assertEquals(1, resultOneBall);
        }

        @Test
        void caseTwoBall() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            int resultTwoBall = computer.getBallCount("234");
            assertEquals(2, resultTwoBall);
        }

        @Test
        void caseThreeBall() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            int resultThreeBall = computer.getBallCount("231");
            assertEquals(3, resultThreeBall);
        }
    }

    @Nested
    class isGameOverTest {

        @Test
        void caseGameOver() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            boolean resultGameOver = computer.isGameOver("123");
            assertTrue(resultGameOver);
        }

        @Test
        void caseNotGameOver() {
            Computer computer = new Computer();
            computer.answer = List.of(1, 2, 3);
            boolean resultNotGameOver = computer.isGameOver("234");
            assertFalse(resultNotGameOver);
        }
    }

}