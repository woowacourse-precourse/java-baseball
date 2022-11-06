package baseball.tool;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeforeVerificationSettingTest {

    @Nested
    class makeNumberSplitListTest{

        @Test
        void case1(){
            int testNumber = 123;
            List<Integer> answerNumber = List.of(1,2,3);
            List<Integer> testNumberList = BeforeVerificationSetting.makeNumberSplitList(testNumber);
            assertEquals(answerNumber, testNumberList);
        }

        @Test
        void case2(){
            int testNumber = 456;
            List<Integer> answerNumber = List.of(4,5,6);
            List<Integer> testNumberList = BeforeVerificationSetting.makeNumberSplitList(testNumber);
            assertEquals(answerNumber, testNumberList);
        }

        @Test
        void case3(){
            int testNumber = 789;
            List<Integer> answerNumber = List.of(7,8,9);
            List<Integer> testNumberList = BeforeVerificationSetting.makeNumberSplitList(testNumber);
            assertEquals(answerNumber, testNumberList);
        }
    }
}