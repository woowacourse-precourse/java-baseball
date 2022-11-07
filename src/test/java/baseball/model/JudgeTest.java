package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class JudgeTest {

    private Judge judge = new Judge();

    @Test
    void isGameSuccess_게임_성공() {
        judge.setAnswer(Arrays.asList(1,2,3));
        judge.setPlayerNumbers(Arrays.asList(1,2,3));

        Assertions.assertTrue(judge.isGameSuccess());
    }

    @Test
    void isGameSuccess_게임_실패() {
        judge.setAnswer(Arrays.asList(1,2,3));
        judge.setPlayerNumbers(Arrays.asList(1,2,4));

        Assertions.assertFalse(judge.isGameSuccess());
    }

    @Test
    void countAllScoreOfStrikeAndBall_총_점수_계산() {
        judge.setAnswer(Arrays.asList(1,2,3));
        judge.setPlayerNumbers(Arrays.asList(1,3,9));

        judge.countAllScoreOfStrikeAndBall();
        Assertions.assertEquals(judge.getStrike(), 1);
        Assertions.assertEquals(judge.getBall(), 1);
    }
}