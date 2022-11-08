package baseball.domain;

import baseball.dto.ScoreResult;
import baseball.dto.ScoreResultType;
import baseball.util.ShowGameMessage;
import baseball.util.input.GameEndInput;
import baseball.util.input.UserInput;
import baseball.util.input.NumberBallsInput;
import java.util.List;

public class NumberBaseballGame {
    private final ShowGameMessage showGameMessage;
    private ScoreBoard scoreBoard;
    private boolean isPlaying;

    public NumberBaseballGame(ShowGameMessage showGameMessage, ScoreBoard scoreBoard) {
        this.showGameMessage = showGameMessage;
        this.scoreBoard = scoreBoard;
        showGameMessage.gameStart();
        isPlaying = true;
    }

    public void play() {
        while (isPlaying) {
            inGame();
        }
    }

    private void inGame() {
        showGameMessage.inputUserNumber();
        ScoreResult result = scoreBoard.getScoreResult(getUserNumberBall());
        showGameMessage.gameResult(result);
        if (result.getScoreResultType() == ScoreResultType.ALL_STRIKE) {
            endGame();
        }
    }

    private void endGame() {
        GameEndInput gameEndInput = new GameEndInput(UserInput.get());
        if (gameEndInput.continueGame()) {
            scoreBoard = new ScoreBoard(NumberBall.makeSystemNumberBalls());
            return;
        }
        isPlaying = false;
    }

    private List<NumberBall> getUserNumberBall() throws IllegalArgumentException {
        NumberBallsInput numberBallsInput = new NumberBallsInput(UserInput.get());
        return numberBallsInput.toNumberBalls();
    }
}