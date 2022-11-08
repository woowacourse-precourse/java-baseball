package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void start() {
        Game game = new Game();
        game.start();
    }

    @Test
    void end() {
        Game game = new Game();
        game.end();
    }

    @Test
    void printInputNumber() {
        Game game = new Game();
        game.printInputNumber();
    }

    @Test
    void countSameNumber() {
        ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Character> user = new ArrayList<>(Arrays.asList('1', '2', '3'));
        Integer answer = 3;
        Integer sameNumber = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i) - '0')) {
                sameNumber++;
            }
        }
        assertThat(sameNumber).isEqualTo(answer);
    }

    @Test
    void checkNothing() {
        Integer sameNumber = 0;
        Boolean answer = true;
        Boolean nothing = false;
        if (sameNumber == 0) {
            nothing = true;
        }
        assertThat(nothing).isEqualTo(answer);
    }

    @Test
    void countStrike() {
        ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Character> user = new ArrayList<>(Arrays.asList('1', '2', '3'));
        Integer answer = 3;
        Integer strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == user.get(i) - '0') {
                strike++;
            }
        }
        assertThat(strike).isEqualTo(answer);
    }

    @Test
    void countBall() {
        Integer sameNumber = 3;
        Integer strike = 1;
        Integer answer = 2;
        Integer ball = sameNumber - strike;
        assertThat(ball).isEqualTo(answer);
    }

    @Test
    void printResult() {
        Game game = new Game();
        game.printResult();
    }

    @Test
    void resetCount() {
        Game game = new Game();
        game.resetCount();
    }
}