package baseball.controller;

import baseball.type.ResultGame;
import baseball.view.OutputView;

public class Game {
    private static ResultGame resultGame = ResultGame.Repeat;

    static void repeatToEnd() {
        while (checkResultIsRepeat()) {
            playOneTime();
        }
    }

    static void playOneTime() {
        Turn.repeatToEnd();
        checkIsUserRepeatGame();
    }

    static boolean checkResultIsRepeat() {
        return resultGame == ResultGame.Repeat;
    }
}
