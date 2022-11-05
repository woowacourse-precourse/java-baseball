package baseball.domain;

import baseball.dto.ScoreResult;
import baseball.dto.ScoreResultType;
import baseball.util.ShowGameMessage;
import baseball.util.input.NumberBallsInput;
import camp.nextstep.edu.missionutils.Console;
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
                if (continueGame(getUserInputString())) {
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

    private String getUserInputString() {
        return Console.readLine();
    }

    private boolean continueGame(String userInput) {
        validateContinueUserInput(userInput);
        if (userInput.charAt(0) == '1') {
            return true;
        }
        return false;
    }

    private void validateContinueUserInput(String userInput) {
        if (userInput.length() > 1) {
            throw new IllegalArgumentException("길이 1초과");
        } else if (!(userInput.charAt(0) == '1' || userInput.charAt(0) == '2')) {
            throw new IllegalArgumentException("1혹은 2만 입력");
        }
    }

    private List<NumberBall> initializeSystemNumberBall() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return numbers.stream().map(NumberBall::new).collect(Collectors.toList());
    }
}