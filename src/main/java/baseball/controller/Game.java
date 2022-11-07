package baseball.controller;

import baseball.type.ResultGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private static ResultGame resultGame = ResultGame.Repeat;

    static void repeatToEnd() {
        OutputView.informStartGame();
        setResultGameIntoRepeat();
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

    static void checkIsUserRepeatGame() {
        String oneIfGameRepeatOrTwo = InputView.checkIsGameRepeatFromUserByGetOneOrTwo();
        if (checkIsOne(oneIfGameRepeatOrTwo)) {
            setResultGameIntoRepeat();
            return;
        }
        setResultGameIntoEnd();
    }

    static boolean checkIsOne(String oneOrTwo) {
        return oneOrTwo.equals("1");
    }

    static void setResultGameIntoRepeat() {
        resultGame = ResultGame.Repeat;
    }

    static void setResultGameIntoEnd() {
        resultGame = ResultGame.End;
    }
}
