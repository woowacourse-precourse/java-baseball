package baseball.game;

import baseball.game.number.Score;

import java.util.List;

import static baseball.game.number.Calculator.*;
import static baseball.game.number.RandomNumbers.*;
import static baseball.userInterface.Input.*;
import static baseball.userInterface.View.*;
import static baseball.userInterface.Output.*;

public class BaseballGame {
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
}
