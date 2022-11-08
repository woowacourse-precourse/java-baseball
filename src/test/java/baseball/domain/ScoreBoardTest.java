package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.dto.ScoreResult;
import baseball.dto.ScoreResultType;
import baseball.util.ShowGameMessage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {
    private ScoreBoard scoreBoard;
    private ShowGameMessage showGameMessage = new ShowGameMessage();
    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    @BeforeEach
    void beforeEach() {
        scoreBoard = new ScoreBoard(makeNumberBalls(1, 2, 3));
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        standardOut = System.out;
    }

    @AfterEach
    void afterEach() {
        System.setOut(standardOut);
    }

    protected String getOutput() {
        return outputStreamCaptor.toString().trim();
    }

    private List<NumberBall> makeNumberBalls(int firstBallNumber, int secondBallNumber, int thirdBallNumber) {
        return List.of(new NumberBall(firstBallNumber), new NumberBall(secondBallNumber),
                new NumberBall(thirdBallNumber));
    }

    @Test
    void 원스트라이크() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(1, 4, 5));
        assertThat(scoreResult.getStrike()).isEqualTo(1);
        assertThat(scoreResult.getBall()).isEqualTo(0);
        assertThat(scoreResult.getScoreResultType()).isEqualTo(ScoreResultType.STRIKE);

        showGameMessage.gameResult(scoreResult);
        assertThat(getOutput()).isEqualTo("1스트라이크");
    }

    @Test
    void 투스트라이크() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(1, 2, 4));
        assertThat(scoreResult.getStrike()).isEqualTo(2);
        assertThat(scoreResult.getBall()).isEqualTo(0);
        assertThat(scoreResult.getScoreResultType()).isEqualTo(ScoreResultType.STRIKE);

        showGameMessage.gameResult(scoreResult);
        assertThat(getOutput()).isEqualTo("2스트라이크");
    }

    @Test
    void 쓰리스트라이크() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(1, 2, 3));
        assertThat(scoreResult.getStrike()).isEqualTo(3);
        assertThat(scoreResult.getBall()).isEqualTo(0);
        assertThat(scoreResult.getScoreResultType()).isEqualTo(ScoreResultType.ALL_STRIKE);

        showGameMessage.gameResult(scoreResult);
        assertThat(getOutput()).isEqualTo("3스트라이크\n"
                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Test
    void 원볼() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(3, 4, 5));
        assertThat(scoreResult.getStrike()).isEqualTo(0);
        assertThat(scoreResult.getBall()).isEqualTo(1);
        assertThat(scoreResult.getScoreResultType()).isEqualTo(ScoreResultType.BALL);

        showGameMessage.gameResult(scoreResult);
        assertThat(getOutput()).isEqualTo("1볼");
    }

    @Test
    void 투볼() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(2, 3, 5));
        assertThat(scoreResult.getStrike()).isEqualTo(0);
        assertThat(scoreResult.getBall()).isEqualTo(2);
        assertThat(scoreResult.getScoreResultType()).isEqualTo(ScoreResultType.BALL);

        showGameMessage.gameResult(scoreResult);
        assertThat(getOutput()).isEqualTo("2볼");
    }

    @Test
    void 쓰리볼() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(2, 3, 1));
        assertThat(scoreResult.getStrike()).isEqualTo(0);
        assertThat(scoreResult.getBall()).isEqualTo(3);
        assertThat(scoreResult.getScoreResultType()).isEqualTo(ScoreResultType.BALL);

        showGameMessage.gameResult(scoreResult);
        assertThat(getOutput()).isEqualTo("3볼");
    }

    @Test
    void 원볼_원스트라이크() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(2, 4, 3));
        assertThat(scoreResult.getStrike()).isEqualTo(1);
        assertThat(scoreResult.getBall()).isEqualTo(1);
        assertThat(scoreResult.getScoreResultType()).isEqualTo(ScoreResultType.BALL_STRIKE);

        showGameMessage.gameResult(scoreResult);
        assertThat(getOutput()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 투볼_원스트라이크() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(2, 1, 3));
        assertThat(scoreResult.getStrike()).isEqualTo(1);
        assertThat(scoreResult.getBall()).isEqualTo(2);
        assertThat(scoreResult.getScoreResultType()).isEqualTo(ScoreResultType.BALL_STRIKE);

        showGameMessage.gameResult(scoreResult);
        assertThat(getOutput()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 낫싱() {
        ScoreResult scoreResult = scoreBoard.getScoreResult(makeNumberBalls(4, 5, 6));
        assertThat(scoreResult.getStrike()).isEqualTo(0);
        assertThat(scoreResult.getBall()).isEqualTo(0);
        assertThat(scoreResult.getScoreResultType()).isEqualTo(ScoreResultType.NOTHING);

        showGameMessage.gameResult(scoreResult);
        assertThat(getOutput()).isEqualTo("낫싱");
    }
}