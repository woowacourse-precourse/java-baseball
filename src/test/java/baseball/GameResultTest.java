package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void strikeResultCase() {
        Map<String,Integer> testResult = new HashMap<>();
        testResult.put("strike",3);
        testResult.put("ball",0);
        boolean gameRunning = GameResult.resultCase(testResult);
        assertTrue(gameRunning);
    }
    @Test
    void ballResultCase() {
        Map<String,Integer> testResult = new HashMap<>();
        testResult.put("ball",3);
        testResult.put("strike",0);
        System.out.println(testResult);
        boolean gameRunning = GameResult.resultCase(testResult);
        assertFalse(gameRunning);
    }
    @Test
    void ballAndStrikeResultCase() {
        Map<String,Integer> testResult = new HashMap<>();
        testResult.put("ball",1);
        testResult.put("strike",2);
        System.out.println(testResult);
        boolean gameRunning = GameResult.resultCase(testResult);
        assertFalse(gameRunning);
    }
}