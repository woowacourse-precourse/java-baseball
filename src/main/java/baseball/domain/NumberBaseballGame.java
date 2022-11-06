package baseball.domain;

import baseball.dto.ScoreResult;
import baseball.dto.ScoreResultType;
import baseball.util.ShowGameMessage;
import baseball.util.input.ContinueInput;
import baseball.util.input.NumberBallsInput;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    private final ShowGameMessage showGameMessage;
    private ScoreBoard scoreBoard;

    public NumberBaseballGame(ShowGameMessage showGameMessage, ScoreBoard scoreBoard) {
        this.showGameMessage = showGameMessage;
        this.scoreBoard = scoreBoard;
        showGameMessage.gameStartMessage();
    }

    public void play() {
        while (scoreBoard.isPlaying()) {
            showGameMessage.inputUserNumberMessage();
            ScoreResult result = scoreBoard.getScoreResult(getUserNumberBall());
            showGameMessage.gameResultMessage(result);
            if (result.getType() == ScoreResultType.ALL_STRIKE) {
                ContinueInput continueInput = new ContinueInput();
                if (continueInput.continueGame()) {
                    scoreBoard.initialize();
                } else {
                    scoreBoard.setIsPlaying();
                }
            }
        }
    }

    private List<NumberBall> getUserNumberBall() throws IllegalArgumentException {
        NumberBallsInput numberBallsInput = new NumberBallsInput();
        return numberBallsInput.toNumberBalls();
    }
}