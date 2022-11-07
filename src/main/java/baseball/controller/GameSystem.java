package baseball.controller;

import baseball.view.Messages;
import baseball.model.Game;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.model.Constants.*;

public class GameSystem {

    public void run() {
        String answer = RESTART;
        while (isRestart(answer)) {
            Game game = new Game();
            play(game);
            Messages.endOrRestart();
            answer = Console.readLine();
        }
    }

    public void play(Game game) {
        boolean gameClear = false;
        while (!gameClear) {
            List<Integer> userNum = inputStartAndGenerateUserNum();
            gameClear = game.isClear(game.getStrikeCount(userNum));
            Messages.printResult(game.getBallCount(userNum), game.getStrikeCount(userNum));
        }
        Messages.gameClear();
    }

    public List<Integer> inputStartAndGenerateUserNum() {
        Messages.inputStart();
        String input = Console.readLine();
        return new User(input).NUMS;
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
