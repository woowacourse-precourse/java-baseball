package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static Game game;

    @BeforeAll
    static void initAll() {
        game = new Game();
    }

    @Test
    void gameInit() {
    }

    @Test
    void makingRandomNum() {
        ArrayList<Integer> randomNum = game.makingRandomNum();
        assertEquals(3, randomNum.size());
        assertTrue(randomNum.get(0) >= 1 && randomNum.get(0) <= 9);
        assertTrue(randomNum.get(1) >= 1 && randomNum.get(0) <= 9);
        assertTrue(randomNum.get(2) >= 1 && randomNum.get(0) <= 9);
    }

    @Test
    void inputNum() {
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(input, game.inputNum());
    }

    @Test
    void comparingNum() {
    }

    @Test
    void checkingStrike() {
        ArrayList<Integer> randomNum = new ArrayList<>();
        randomNum.add(1);
        randomNum.add(2);
        randomNum.add(3);
        String inputNum = "123";
        int ballCount = 0;
        int answer = game.checkingStrike(randomNum, inputNum, ballCount);
        assertEquals(3, answer);
    }

    @Test
    void checkingBall() {
        ArrayList<Integer> randomNum = new ArrayList<>();
        randomNum.add(1);
        randomNum.add(2);
        randomNum.add(3);
        String inputNum = "312";
        int ballCount = 0;
        int answer = game.checkingBall(randomNum, inputNum, ballCount);
        assertEquals(3, answer);
    }

    @Test
    void keepGoing() {
        String input = "1";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertTrue(game.keepGoing());

        String inputF = "2";
        OutputStream outF = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outF));
        InputStream inF = new ByteArrayInputStream(inputF.getBytes());
        System.setIn(inF);
        assertFalse(game.keepGoing());

        String inputFF = "2r";
        OutputStream outFF = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outFF));
        InputStream inFF = new ByteArrayInputStream(inputFF.getBytes());
        System.setIn(inFF);
        assertFalse(game.keepGoing());
    }
}