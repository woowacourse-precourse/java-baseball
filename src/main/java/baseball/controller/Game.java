package baseball.controller;

import baseball.type.ResultGame;
import baseball.view.OutputView;

public class Game {
    private static ResultGame resultGame = ResultGame.Repeat;

    static void repeatToEnd() {
        OutputView.informStartGame();
        while (checkCanRepeat()) {
            playOneTime();
        }
    }

    static void playOneTime() {
        Turn.repeatToEnd();
        checkIsUserRepeatGame();
    }

    static boolean checkCanRepeat() {
        return resultGame == ResultGame.Repeat;
    }
}
