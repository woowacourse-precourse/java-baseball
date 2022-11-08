package baseball.controller;

import baseball.view.Messages;
import baseball.service.Game;
import camp.nextstep.edu.missionutils.Console;


import static baseball.model.Constants.*;

public class GameSystem {

    public void run() {
        String answer = RESTART;
        while (isRestart(answer)) {
            Game game = new Game();
            game.play();
            Messages.endOrRestart();
            answer = Console.readLine();
        }
    }

    public boolean isRestart(String answer) {
        if (answer.equals(RESTART)) {
            return true;
        } else if (answer.equals(END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
