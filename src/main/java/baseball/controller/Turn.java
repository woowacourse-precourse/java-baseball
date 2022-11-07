package baseball.controller;

import baseball.type.ResultTurn;

public class Turn {
    static ResultTurn resultTurn;

    static void repeatToEnd() {
        while(checkCanRepeat()) {
            playOneTurn();
        }
    }

    static void playOneTurn() {

    }

    static boolean checkCanRepeat() {
        return resultTurn != ResultTurn.Out;
    }
}
