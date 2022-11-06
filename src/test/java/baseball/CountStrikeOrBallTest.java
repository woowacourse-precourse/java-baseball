package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountStrikeOrBallTest {

    @Nested
    class getStrikeNumber{

        @Test
        void case1(){
            int answerNumber = 3;
            int testNumber = 123;
            List<Integer> testNumber2 = List.of(1,2,3);
            int testResult = CountStrikeOrBall.getStrikeNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void case2(){
            int answerNumber = 2;
            int testNumber = 129;
            List<Integer> testNumber2 = List.of(1,2,8);
            int testResult = CountStrikeOrBall.getStrikeNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void case3(){
            int answerNumber = 1;
            int testNumber = 149;
            List<Integer> testNumber2 = List.of(9,4,1);
            int testResult = CountStrikeOrBall.getStrikeNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void case4(){
            int answerNumber = 0;
            int testNumber = 129;
            List<Integer> testNumber2 = List.of(2,9,1);
            int testResult = CountStrikeOrBall.getStrikeNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }
    }

    @Nested
    class getBallNumber {
        @Test
        void case1(){
            int answerNumber = 0;
            int testNumber = 129;
            List<Integer> testNumber2 = List.of(1,2,8);
            int testResult = CountStrikeOrBall.getBallNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void case2(){
            int answerNumber = 1;
            int testNumber = 192;
            List<Integer> testNumber2 = List.of(1,2,8);
            int testResult = CountStrikeOrBall.getBallNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void case3(){
            int answerNumber = 3;
            int testNumber = 192;
            List<Integer> testNumber2 = List.of(9,2,1);
            int testResult = CountStrikeOrBall.getBallNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void case4(){
            int answerNumber = 2;
            int testNumber = 192;
            List<Integer> testNumber2 = List.of(2,9,1);
            int testResult = CountStrikeOrBall.getBallNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }
    }

}