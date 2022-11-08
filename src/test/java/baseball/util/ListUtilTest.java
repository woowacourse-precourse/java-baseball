package baseball.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilTest {
    ListUtil listUtil = new ListUtil();

    @Test
    void stringToIntegerList() {
        String input = "123";
        List<Integer> list = listUtil.stringToIntegerList(input);

        assertEquals(list, List.of(1, 2, 3));
    }

    @Test
    void countDiffLocationValues() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> computerNumbers = List.of(3, 2, 1);

        assertEquals(listUtil.countDiffLocationValues(userNumbers, computerNumbers), 2);
    }

    @Test
    void countSameLocationValues() {
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> computerNumbers = List.of(3, 2, 1);

        assertEquals(listUtil.countSameLocationValues(userNumbers, computerNumbers), 1);
    }
}