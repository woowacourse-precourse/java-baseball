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
    private static final int PROGRAM_EXIT = 0;
    private boolean isPlayAgain = true;

    public BaseballGame() {
        viewStartGameMessage();
    }

    public void start() {
        do {
            int programState = play();
            if (programState == 0){
                return;
            }
            askPlayAgain();
        } while (isPlayAgain);
    }

    private int play() {
        List<Integer> answer = createThreeRandomNumbers();
        Score userScore;
        do {
            List<Integer> userInput = getUserInput();
            if (userInput.equals(List.of(0))){
                return 0;
            }
            userScore = scoreCalculator(answer, userInput);
            printScore(userScore);
        } while(!isWin(userScore));
        return 1;
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
        if (isPlayAgainCode == 0) {
            isPlayAgain = false;
            return;
        }
        if (isPlayAgainCode == DO_NOT_PLAY_AGAIN_CONDITION) {
            isPlayAgain = false;
        }
    }
}
