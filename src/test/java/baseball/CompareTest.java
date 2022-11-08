package baseball;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTest {
    Compare compare;


    @Test
    void testMatchResult() {
        compare = new Compare();
        ArrayList<Integer> checkAnswerNumList = new ArrayList<Integer>();
        ArrayList<Integer> checkPlayerNumList = new ArrayList<Integer>();

        checkAnswerNumList.add(1);
        checkAnswerNumList.add(2);
        checkAnswerNumList.add(3);

        checkPlayerNumList.add(1);
        checkPlayerNumList.add(2);
        checkPlayerNumList.add(3);

        assertEquals(3, compare.getMatchResult(checkAnswerNumList, checkPlayerNumList));
    }

    @Test
    void testStrikeCount() {
        compare = new Compare();
        ArrayList<Integer> checkAnswerNumList = new ArrayList<Integer>();
        ArrayList<Integer> checkPlayerNumList = new ArrayList<Integer>();
        checkAnswerNumList.add(4);
        checkAnswerNumList.add(5);
        checkAnswerNumList.add(6);

        checkPlayerNumList.add(4);
        checkPlayerNumList.add(5);
        checkPlayerNumList.add(6);
        assertEquals(3, compare.strikeCount(checkAnswerNumList, checkPlayerNumList));
    }
}
