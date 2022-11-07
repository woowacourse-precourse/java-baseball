package baseball.count;

import baseball.count.CountStrikeOrBall;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountStrikeOrBallTest {

    @Nested
    class getStrikeNumber {

        @Test
        void 같은_숫자_같은_위치에_있으면_스트라이크_3개가_있을_경우() {
            int answerNumber = 3;
            int testNumber = 123;
            List<Integer> testNumber2 = List.of(1, 2, 3);
            int testResult = CountStrikeOrBall.getStrikeNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void 같은_숫자_같은_위치에_있으면_스트라이크_2개_있을_경우() {
            int answerNumber = 2;
            int testNumber = 129;
            List<Integer> testNumber2 = List.of(1, 2, 8);
            int testResult = CountStrikeOrBall.getStrikeNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void 같은_숫자_같은_위치에_있으면_스트라이크_1개_있을_경우() {
            int answerNumber = 1;
            int testNumber = 149;
            List<Integer> testNumber2 = List.of(9, 4, 1);
            int testResult = CountStrikeOrBall.getStrikeNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void 같은_숫자_같은_위치에_있으면_스트라이크_0개_있을_경우() {
            int answerNumber = 0;
            int testNumber = 129;
            List<Integer> testNumber2 = List.of(2, 9, 1);
            int testResult = CountStrikeOrBall.getStrikeNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }
    }

    @Nested
    class getBallNumber {
        @Test
        void 같은_숫자_다른_위치에_있으면_볼_0개_있을_경우() {
            int answerNumber = 0;
            int testNumber = 129;
            List<Integer> testNumber2 = List.of(1, 2, 8);
            int testResult = CountStrikeOrBall.getBallNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void 같은_숫자_다른_위치에_있으면_볼_1개_있을_경우() {
            int answerNumber = 1;
            int testNumber = 192;
            List<Integer> testNumber2 = List.of(1, 2, 8);
            int testResult = CountStrikeOrBall.getBallNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void 같은_숫자_다른_위치에_있으면_볼_3개_있을_경우() {
            int answerNumber = 3;
            int testNumber = 192;
            List<Integer> testNumber2 = List.of(9, 2, 1);
            int testResult = CountStrikeOrBall.getBallNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void 같은_숫자_다른_위치에_있으면_볼_2개_있을_경우() {
            int answerNumber = 2;
            int testNumber = 192;
            List<Integer> testNumber2 = List.of(2, 9, 1);
            int testResult = CountStrikeOrBall.getBallNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }
    }
}