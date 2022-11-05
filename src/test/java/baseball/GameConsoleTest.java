package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameConsoleTest {

    private GameConsole gameConsole;

    @BeforeEach
    public void setUp() {
        gameConsole = new GameConsole();
    }

    @Test
    void 스트라이크_개수_검사() {
        // 0개
        List<Integer> strikeTestList1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> strikeTestList2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        // 1개
        List<Integer> strikeTestList3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> strikeTestList4 = new ArrayList<>(Arrays.asList(1, 4, 5));
        // 2개
        List<Integer> strikeTestList5 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> strikeTestList6 = new ArrayList<>(Arrays.asList(1, 2, 4));
        // 3개
        List<Integer> strikeTestList7 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> strikeTestList8 = new ArrayList<>(Arrays.asList(1, 2, 3));

        assertEquals(0, gameConsole.strikeCount(strikeTestList1, strikeTestList2));
        assertEquals(1, gameConsole.strikeCount(strikeTestList3, strikeTestList4));
        assertEquals(2, gameConsole.strikeCount(strikeTestList5, strikeTestList6));
        assertEquals(3, gameConsole.strikeCount(strikeTestList7, strikeTestList8));


    }

    @Test
    void 볼_개수_검사() {

        // 0개
        List<Integer> ballTestList1 = new ArrayList<>(Arrays.asList(6, 2, 4));
        List<Integer> ballTestList2 = new ArrayList<>(Arrays.asList(6, 2, 4));
        // 1개
        List<Integer> ballTestList3 = new ArrayList<>(Arrays.asList(1, 2, 4));
        List<Integer> ballTestList4 = new ArrayList<>(Arrays.asList(2, 6, 4));
        // 2개
        List<Integer> ballTestList5 = new ArrayList<>(Arrays.asList(6, 2, 4));
        List<Integer> ballTestList6 = new ArrayList<>(Arrays.asList(4, 3, 6));

        assertEquals(0, gameConsole.ballCount(ballTestList1, ballTestList2));
        assertEquals(1, gameConsole.ballCount(ballTestList3, ballTestList4));
        assertEquals(2, gameConsole.ballCount(ballTestList5, ballTestList6));
    }

    /*
    @Test

    void 낫싱_검사(){
        // 낫싱 O
        List<Integer> nothingTestList1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> nothingTestList2 = new ArrayList<>(Arrays.asList(4,5,6));
        // 낫싱 X
        List<Integer> nothingTestList3 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> nothingTestList4 = new ArrayList<>(Arrays.asList(4,5,1));

        assertEquals("낫싱", gameConsole.nothingCheck(nothingTestList1,nothingTestList2));
        assertEquals("", gameConsole.nothingCheck(nothingTestList3,nothingTestList4));

    }
    */
}