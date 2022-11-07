package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static baseball.model.Judge.Result.*;

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
    void isStrikeOrBall_볼_스트라이크_판별() {
        judge.setAnswer(Arrays.asList(1,2,3));
        judge.setPlayerNumbers(Arrays.asList(1,3,9));

        Assertions.assertEquals(judge.isBallOrStrike(0), STRIKE);
        Assertions.assertEquals(judge.isBallOrStrike(1), BALL);
        Assertions.assertEquals(judge.isBallOrStrike(2), NOTHING);
    }

    @Test
    void countScoreOfStrikeAndBall_총_점수_계산() {
        judge.setAnswer(Arrays.asList(1,2,3));
        judge.setPlayerNumbers(Arrays.asList(1,3,9));

        Score score = judge.countScoreOfStrikeAndBall();
        Assertions.assertEquals(score.getStrike(), 1);
        Assertions.assertEquals(score.getBall(), 1);
    }
}