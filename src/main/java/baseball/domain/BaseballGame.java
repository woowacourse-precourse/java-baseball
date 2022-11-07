package baseball.domain;

import static baseball.utils.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final int RESTART = 1;
    private static final int END = 2;

    Referee referee;
    User user;
    TextForGame textForGame;
    List<Integer> result;
    boolean isPlaying;

    public BaseballGame() {
        referee = new Referee();
        user = new User();
        textForGame = new TextForGame();
        result = new ArrayList<>();

        start();
    }

    private void start() {
        isPlaying = true;
        referee.setDefenceNumber();
        playingOneRound();
    }

    private void playingOneRound() {
        textForGame.inputText();
        List<Integer> offenceNumber = user.inputGameNumber();
        referee.setOffenceNumber(offenceNumber);

        result = referee.getBallAndStrikeCount();
        textForGame.printResult(result.get(BALL_INDEX), result.get(STRIKE_INDEX));

        if (result.get(STRIKE_INDEX) == GAME_NUMBER_SIZE) {
            endOrRestart();
        }

        if(isPlaying) {
            playingOneRound();
        }
    }

    private void endOrRestart() {
        textForGame.printEndAndAskAboutNewGame();
        String numberString = user.inputEndOrRestart();
        int number = Integer.parseInt(numberString);

        if (number == END) {
            end();
        }
        if (number == RESTART) {
            start();
        }
    }

    private void end() {
        isPlaying = false;
    }
}
