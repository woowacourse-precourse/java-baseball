package baseball.controller;

import baseball.type.GameStatus;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private static GameStatus gameStatus = GameStatus.InProgress;

    static void repeatUntilEnd() {
        OutputView.informStartGame();
        setResultGameInProgress();
        while (checkIsGameStatusInProgress()) {
            playOneTime();
        }
    }

    static void playOneTime() {
        Turn.repeatToEnd();
        checkIsUserRepeatGame();
    }

    static boolean checkIsGameStatusInProgress() {
        return gameStatus == GameStatus.InProgress;
    }

    static void checkIsUserRepeatGame() {
        String oneIfGameRepeatOrTwo = InputView.checkIsGameRepeatFromUserByGetOneOrTwo();
        if (checkIsOne(oneIfGameRepeatOrTwo)) {
            setResultGameInProgress();
            return;
        }
        setResultGameEnd();
    }

    static boolean checkIsOne(String oneOrTwo) {
        return oneOrTwo.equals("1");
    }

    static void setResultGameInProgress() {
        gameStatus = GameStatus.InProgress;
    }

    static void setResultGameEnd() {
        gameStatus = GameStatus.End;
    }
}
