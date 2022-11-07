package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    Referee referee = new Referee(Balls.createBalls(Arrays.asList(1, 2, 3)));

    @Test
    @DisplayName("3스트라이크 판단 테스트")
    void judgeStrikeScoreTest() throws Exception {
        Hint hint = referee.judgeScore(Balls.createBalls(Arrays.asList(1, 2, 3)));
        assertThat(hint.getScorePoint(Score.STRIKE)).isEqualTo(3);
    }

    @Test
    @DisplayName("3볼 판단 테스트")
    void judgeBallScoreTest() throws Exception {
        Hint hint = referee.judgeScore(Balls.createBalls(Arrays.asList(2, 3, 1)));
        assertThat(hint.getScorePoint(Score.BALL)).isEqualTo(3);
    }

    @Test
    @DisplayName("1스트라이크 2볼 판단 테스트")
    void judgeStrikeAndBallScoreTest() throws Exception {
        Hint hint = referee.judgeScore(Balls.createBalls(Arrays.asList(1, 3, 2)));
        assertAll(
                () -> assertThat(hint.getScorePoint(Score.STRIKE)).isEqualTo(1),
                () -> assertThat(hint.getScorePoint(Score.BALL)).isEqualTo(2)
        );
    }

}