package baseball.controller;

import baseball.type.ResultGame;

public class Game {
    private static ResultGame resultGame = ResultGame.Repeat;

    static void repeatToEnd() {
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
