package baseball.domain;

import baseball.dto.ScoreResult;
import baseball.dto.ScoreResultType;
import baseball.util.ShowGameMessage;
import baseball.util.input.ContinueInput;
import baseball.util.input.NumberBallsInput;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseballGame {
    private final ShowGameMessage showGameMessage = new ShowGameMessage();
    private ScoreBoard scoreBoard;

    private void init() {
        scoreBoard = new ScoreBoard(initializeSystemNumberBall());
        showGameMessage.gameStartMessage();
    }

    public void play() {
        init();
        while (scoreBoard.isPlaying()) {
            showGameMessage.inputUserNumberMessage();
            ScoreResult result = scoreBoard.getScoreResult(getUserNumberBall());
            showGameMessage.gameResultMessage(result);
            if (result.getType() == ScoreResultType.ALL_STRIKE) {
                ContinueInput continueInput = new ContinueInput();
                if (continueInput.continueGame()) {
                    init();
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

    private List<NumberBall> initializeSystemNumberBall() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return numbers.stream().map(NumberBall::new).collect(Collectors.toList());
    }
}