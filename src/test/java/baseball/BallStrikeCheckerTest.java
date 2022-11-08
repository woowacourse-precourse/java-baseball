package baseball;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

class BallStrikeCheckerTest {

    @Test
    void countSumOfBallAndStrike() {
        BallStrikeChecker ballStrikeChecker;
        ballStrikeChecker = new BallStrikeChecker();
        assertThat(ballStrikeChecker.countSumOfBallAndStrike("123", "421"))
                .isEqualTo(2);
        assertThat(ballStrikeChecker.countSumOfBallAndStrike("789", "897"))
                .isEqualTo(3);
        assertThat(ballStrikeChecker.countSumOfBallAndStrike("159", "234"))
                .isEqualTo(0);
    }

    @Test
    void countStrike() {
        BallStrikeChecker ballStrikeChecker;
        ballStrikeChecker = new BallStrikeChecker();
        assertThat(ballStrikeChecker.countStrike("123", "124"))
                .isEqualTo(2);
        assertThat(ballStrikeChecker.countStrike("567", "567"))
                .isEqualTo(3);
        assertThat(ballStrikeChecker.countStrike("987", "654"))
                .isEqualTo(0);
    }

    @Test
    void countBall() {
        BallStrikeChecker ballStrikeChecker;
        ballStrikeChecker = new BallStrikeChecker();
        assertThat(ballStrikeChecker.countBall("123", "213"))
                .isEqualTo(2);
        assertThat(ballStrikeChecker.countBall("567", "568"))
                .isEqualTo(0);
        assertThat(ballStrikeChecker.countBall("248", "824"))
                .isEqualTo(3);
    }

}