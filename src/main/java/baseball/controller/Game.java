package baseball.controller;

import baseball.type.GameStatus;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private GameStatus gameStatus = GameStatus.InProgress;

    void repeatUntilEnd() {
        OutputView.informStartGame();
        setResultGameInProgress();
        while (checkIsGameStatusInProgress()) {
            playOneTime();
        }
    }

    void playOneTime() {
        Turn turn = new Turn();
        turn.repeatToEnd();
        checkIsUserRepeatGame();
    }

    boolean checkIsGameStatusInProgress() {
        return this.gameStatus == GameStatus.InProgress;
    }

    void checkIsUserRepeatGame() {
        String oneIfGameRepeatOrTwo = InputView.checkIsGameRepeatFromUserByGetOneOrTwo();
        if (checkIsOne(oneIfGameRepeatOrTwo)) {
            setResultGameInProgress();
            return;
        }
        setResultGameEnd();
    }

    boolean checkIsOne(String oneOrTwo) {
        return oneOrTwo.equals("1");
    }

    void setResultGameInProgress() {
        this.gameStatus = GameStatus.InProgress;
    }

    void setResultGameEnd() {
        this.gameStatus = GameStatus.End;
    }
}
