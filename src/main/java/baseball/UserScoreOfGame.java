package baseball;

import static Config.BaseResponseStatus .*;
import java.util.List;
public class UserScoreOfGame {
    private Integer strike;
    private Integer ball;

    public UserScoreOfGame() {
        strike = 0;
        ball = 0;
    }

    public void countScore(ComputerOfGame computerOfGame, GamePlayer gamePlayer) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int result = computerOfGame.checkAnswer(gamePlayer, i);
            if (result == STRIKE_RESULT) {
                strike++;
            }
            if (result == BALL_RESULT) {
                ball++;
            }
        }
    }

    public String scoreString() {
        String message = "";
        if (strike == 0 && ball == 0) {
            return RESULT_NOTHING_MESSAGE;
        }
        if (ball != 0) {
            message += ball + RESULT_BALL_MESSAGE + " ";
        }
        if (strike != 0) {
            message += strike + RESULT_STRIKE_MESSAGE;
        }
        return message;
    }

    private void resetScore() {
        ball = 0;
        strike = 0;
    }

    public boolean isAllStrike() {
        int strikeResult = strike;
        resetScore();
        return strikeResult == NUMBER_LENGTH;
    }
}
