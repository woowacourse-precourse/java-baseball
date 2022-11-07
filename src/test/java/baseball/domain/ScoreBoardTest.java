package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.dto.ScoreResult;
import baseball.dto.ScoreResultType;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {
    private ScoreBoard scoreBoard;

    @BeforeEach
    void BeforeEach() {
        scoreBoard = new ScoreBoard(makeNumberBalls(1, 2, 3));
    }

    private List<NumberBall> makeNumberBalls(int firstBallNumber, int secondBallNumber, int thirdBallNumber) {
        return List.of(new NumberBall(firstBallNumber), new NumberBall(secondBallNumber),
                new NumberBall(thirdBallNumber));
    }

    @Test
    @DisplayName("1스트라이크 발생")
    void strikeCase1() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(1, 4, 5));
        assertThat(scoreResult.getStrike()).isEqualTo(1);
        assertThat(scoreResult.getBall()).isEqualTo(0);
        assertThat(scoreResult.getType()).isEqualTo(ScoreResultType.STRIKE);
    }

    @Test
    @DisplayName("2스트라이크 발생")
    void strikeCase2() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(1, 2, 4));
        assertThat(scoreResult.getStrike()).isEqualTo(2);
        assertThat(scoreResult.getBall()).isEqualTo(0);
        assertThat(scoreResult.getType()).isEqualTo(ScoreResultType.STRIKE);
    }

    @Test
    @DisplayName("3스트라이크 발생")
    void strikeCase3() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(1, 2, 3));
        assertThat(scoreResult.getStrike()).isEqualTo(3);
        assertThat(scoreResult.getBall()).isEqualTo(0);
        assertThat(scoreResult.getType()).isEqualTo(ScoreResultType.ALL_STRIKE);
    }

    @Test
    @DisplayName("1볼 발생")
    void ballCase1() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(3, 4, 5));
        assertThat(scoreResult.getStrike()).isEqualTo(0);
        assertThat(scoreResult.getBall()).isEqualTo(1);
        assertThat(scoreResult.getType()).isEqualTo(ScoreResultType.BALL);
    }

    @Test
    @DisplayName("2볼 발생")
    void ballCase2() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(2, 3, 5));
        assertThat(scoreResult.getStrike()).isEqualTo(0);
        assertThat(scoreResult.getBall()).isEqualTo(2);
        assertThat(scoreResult.getType()).isEqualTo(ScoreResultType.BALL);
    }

    @Test
    @DisplayName("3볼 발생")
    void ballCase3() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(2, 3, 1));
        assertThat(scoreResult.getStrike()).isEqualTo(0);
        assertThat(scoreResult.getBall()).isEqualTo(3);
        assertThat(scoreResult.getType()).isEqualTo(ScoreResultType.BALL);
    }
    @Test
    @DisplayName("1스트라이크 1볼 발생")
    void strikeAndBallCase1() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(2, 4, 3));
        assertThat(scoreResult.getStrike()).isEqualTo(1);
        assertThat(scoreResult.getBall()).isEqualTo(1);
        assertThat(scoreResult.getType()).isEqualTo(ScoreResultType.STRIKE_BALL);
    }
    @Test
    @DisplayName("1스트라이크 2볼 발생")
    void strikeAndBallCase2() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(2, 1, 3));
        assertThat(scoreResult.getStrike()).isEqualTo(1);
        assertThat(scoreResult.getBall()).isEqualTo(2);
        assertThat(scoreResult.getType()).isEqualTo(ScoreResultType.STRIKE_BALL);
    }
}