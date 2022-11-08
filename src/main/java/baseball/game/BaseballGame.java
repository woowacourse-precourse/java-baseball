package baseball.game;

import baseball.game.number.Score;

import java.util.List;

import static baseball.game.number.Calculator.*;
import static baseball.game.number.RandomNumbers.*;
import static baseball.userInterface.Input.*;
import static baseball.userInterface.View.*;
import static baseball.userInterface.Output.*;

public class BaseballGame {
    private static final int END_GAME_CONDITION = 3;
    private static final int DO_NOT_PLAY_AGAIN_CONDITION = 2;
    private boolean isPlayAgain = true;

    public BaseballGame() {
        viewStartGameMessage();
    }

    public void start() {
        do {
            play();
            askPlayAgain();
        } while (isPlayAgain);
    }

    private void play() {
        List<Integer> answer = createThreeRandomNumbers();
        Score userScore;
        do {
            List<Integer> userInput = getUserInput();
            userScore = scoreCalculator(answer, userInput);
            printScore(userScore);
        } while(!isWin(userScore));
    }

    public boolean isWin(Score userScore) {
        int strike = userScore.getStrike();
        if (strike == END_GAME_CONDITION) {
            viewEndGameMessage();
            return true;
        }
        return false;
    }

    private void askPlayAgain() {
        int isPlayAgainCode = getIsPlayAgainCode();
        if (isPlayAgainCode == DO_NOT_PLAY_AGAIN_CONDITION) {
            isPlayAgain = false;
        }
    }
}
