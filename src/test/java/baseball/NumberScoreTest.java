package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NumberScoreTest {
    int loopFrequency = 3;
    @Test
    void numberCount() {
        int userNumber = 152;
        List<Integer> randomList = new ArrayList<>(Arrays.asList(5,1,3));
        Map<String, Integer> resultTest = NumberScore.numberCount(userNumber,randomList,loopFrequency);
        assertEquals(2,resultTest.get("ball"));
        assertEquals(0,resultTest.get("strike"));
    }
}