package baseball.util;

import baseball.service.GameSetting;

import static baseball.service.GameCommand.*;
import static baseball.util.MessageConstant.*;

public class Message {

    public void initialGameMessage() {
        System.out.println(START_GAME_MESSAGE.getMessage());
    }

    public void askPlayerInputAnswer() {
        System.out.print(INPUT_NUMBER_MESSAGE.getMessage());
    }

    public void gameResultMessage(int countBall, int countStrike) {
        if (countStrike == GameSetting.GAME_END_CONDITION.getAttribute()) {
            System.out.println(countStrike + STRIKE.getMessage());
            System.out.printf((GAME_FINISH_MESSAGE.getMessage()) + "%n", GameSetting.GAME_END_CONDITION.getAttribute());
        } else if (countBall != 0 && countStrike == 0) {
            System.out.println(countBall + BALL.getMessage());
        } else if (countBall == 0 && countStrike != 0) {
            System.out.println(countStrike + STRIKE.getMessage());
        } else if (countBall != 0 && countStrike != 0) {
            System.out.println(countBall + BALL.getMessage() + " " + countStrike + STRIKE.getMessage());
        } else {
            System.out.println(NOTHING.getMessage());
        }
    }

    public void askPlayerReplayMessage() {
        System.out.printf((REPLAY_GAME_MESSAGE.getMessage()) + "%n", RETRY.getCommand(), QUIT.getCommand());

    }

}
