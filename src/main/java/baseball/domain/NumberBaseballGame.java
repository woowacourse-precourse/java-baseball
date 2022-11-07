package baseball.domain;

import baseball.dto.ScoreResult;
import baseball.dto.ScoreResultType;
import baseball.util.ShowGameMessage;
import baseball.util.input.ContinueInput;
import baseball.util.input.NumberBallsInput;
import java.util.List;

public class NumberBaseballGame {
    private final ShowGameMessage showGameMessage;
    private ScoreBoard scoreBoard;
    private boolean isPlaying;

    public NumberBaseballGame(ShowGameMessage showGameMessage, ScoreBoard scoreBoard) {
        this.showGameMessage = showGameMessage;
        this.scoreBoard = scoreBoard;
        showGameMessage.gameStartMessage();
        isPlaying = true;
    }

    public void play() {
        while (isPlaying) {
            showGameMessage.inputUserNumberMessage();
            ScoreResult result = scoreBoard.getScoreResult(getUserNumberBall());
            showGameMessage.gameResultMessage(result);
            if (result.getScoreResultType() == ScoreResultType.ALL_STRIKE) {
                endGame();
            }
        }
    }

    private void endGame() {
        ContinueInput continueInput = new ContinueInput();
        if (continueInput.continueGame()) {
            scoreBoard = new ScoreBoard(NumberBall.systemNumberBalls());
            return;
        }
        isPlaying = false;
    }

    private List<NumberBall> getUserNumberBall() throws IllegalArgumentException {
        NumberBallsInput numberBallsInput = new NumberBallsInput();
        return numberBallsInput.toNumberBalls();
    }
}