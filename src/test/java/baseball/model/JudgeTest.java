package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class JudgeTest {

    private Computer computer = new Computer();
    private Player player = new Player();

    @Test
    void isGameSuccess_게임_성공() {
        computer.setAnswer(Arrays.asList(1,2,3));
        player.setPlayerNumbers("123");

        Judge judge = new Judge(computer, player);

        Assertions.assertTrue(judge.isGameSuccess());
    }

    @Test
    void isGameSuccess_게임_실패() {
        computer.setAnswer(Arrays.asList(1,2,3));
        player.setPlayerNumbers("124");

        Judge judge = new Judge(computer, player);

        Assertions.assertFalse(judge.isGameSuccess());
    }
}