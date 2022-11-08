package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void gameInit() {
    }

    @Test
    void makingRandomNum() {
    }

    @Test
    void inputNum() {
    }

    @Test
    void comparingNum() {
    }

    @Test
    void checkingStrike() {
    }

    @Test
    void checkingBall() {
        Game game = new Game();
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
    }
}