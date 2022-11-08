package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalTest {

    @Test
    void test1() {
        ComparisonNumber comparisonNumber = new ComparisonNumber();
        List<Integer> target = new ArrayList<>(List.of(1,2,3));
        List<Integer> user = new ArrayList<>(List.of(1,2,4));
        comparisonNumber.checkResult(target, user);
        String result = comparisonNumber.Message();

        assertEquals("2스트라이크", result);
    }
    @Test
    void test2() {
        ComparisonNumber comparisonNumber = new ComparisonNumber();
        List<Integer> target = new ArrayList<>(List.of(1,2,3));
        List<Integer> user = new ArrayList<>(List.of(3,1,2));
        comparisonNumber.checkResult(target, user);
        String result = comparisonNumber.Message();

        assertEquals("3볼", result);
    }
    @Test
    void test3() {
        ComparisonNumber comparisonNumber = new ComparisonNumber();
        List<Integer> target = new ArrayList<>(List.of(1,2,3));
        List<Integer> user = new ArrayList<>(List.of(4,5,6));
        comparisonNumber.checkResult(target, user);
        String result = comparisonNumber.Message();

        assertEquals("낫싱", result);
    }
    @Test
    void test4() {
        ComparisonNumber comparisonNumber = new ComparisonNumber();
        List<Integer> target = new ArrayList<>(List.of(3,2,1));
        List<Integer> user = new ArrayList<>(List.of(1,2,4));
        comparisonNumber.checkResult(target, user);
        String result = comparisonNumber.Message();

        assertEquals("1볼 1스트라이크", result);
    }
}
