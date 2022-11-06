package baseball.domain;

import static baseball.utils.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

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

        startAndPlaying();
    }

    private void startAndPlaying() {
        isPlaying = true;
        referee.setDefenceNumber();

        while (isPlaying) {
            textForGame.inputText();
            List<Integer> offenceNumber = user.inputGameNumber();
            referee.setOffenceNumber(offenceNumber);

            result = referee.getBallAndStrikeCount();

            textForGame.printResult(result.get(BALL_INDEX), result.get(STRIKE_INDEX));

            if (result.get(STRIKE_INDEX) == GAME_NUMBER_SIZE) {
                endOrRestart();
            }
        }
    }

    private void endOrRestart() {
        textForGame.printEndAndAskAboutNewGame();
        String numberString = user.inputEndOrRestart();
        int number = Integer.parseInt(numberString);

        if (number == END) {
            isPlaying = false;
        }
        if (number == RESTART) {
            startAndPlaying();
        }
    }
}
