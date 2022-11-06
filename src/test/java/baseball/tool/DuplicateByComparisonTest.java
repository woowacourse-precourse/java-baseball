package baseball.tool;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateByComparisonTest {

    @Nested
    class findOverlapNumber{

        @Test
        void case1(){
            int testNumber = 123;
            List<Integer> testNumber2 = List.of(1,2,4);
            List<Integer> answerNumber = List.of(1,2);
            List<Integer> testResult = DuplicateByComparison.findOverlapNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void case2(){
            int testNumber = 753;
            List<Integer> testNumber2 = List.of(5,4,2);
            List<Integer> answerNumber = List.of(5);
            List<Integer> testResult = DuplicateByComparison.findOverlapNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void case3(){
            int testNumber = 975;
            List<Integer> testNumber2 = List.of(1,2,3);
            List<Integer> answerNumber = List.of();
            List<Integer> testResult = DuplicateByComparison.findOverlapNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }

        @Test
        void case4(){
            int testNumber = 321;
            List<Integer> testNumber2 = List.of(1,2,3);
            List<Integer> answerNumber = List.of(1,2,3);
            List<Integer> testResult = DuplicateByComparison.findOverlapNumber(testNumber2, testNumber);
            assertEquals(answerNumber, testResult);
        }
    }
}