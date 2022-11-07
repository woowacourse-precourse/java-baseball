package baseball.tool;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSplitToolTest {

    @Nested
    class makeNumberSplitListTest {

        @Test
        void 숫자를_리스트로_한개씩_쪼개기_숫자_123() {
            int testNumber = 123;
            List<Integer> answerNumber = List.of(1, 2, 3);
            List<Integer> testNumberList = NumberSplitTool.makeNumberSplitList(testNumber);
            assertEquals(answerNumber, testNumberList);
        }

        @Test
        void 숫자를_리스트로_한개씩_쪼개기_숫자_456() {
            int testNumber = 456;
            List<Integer> answerNumber = List.of(4, 5, 6);
            List<Integer> testNumberList = NumberSplitTool.makeNumberSplitList(testNumber);
            assertEquals(answerNumber, testNumberList);
        }

        @Test
        void 숫자를_리스트로_한개씩_쪼개기_숫자_789() {
            int testNumber = 789;
            List<Integer> answerNumber = List.of(7, 8, 9);
            List<Integer> testNumberList = NumberSplitTool.makeNumberSplitList(testNumber);
            assertEquals(answerNumber, testNumberList);
        }
    }

}