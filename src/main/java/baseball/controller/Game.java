package baseball.controller;

import baseball.model.Target;
import baseball.constant.GameStatus;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Game {
    private GameStatus gameStatus = GameStatus.InProgress;
    private Target target;

    public Game() {
        this.target = new Target();
    }

    public Game(List<Integer> testTargetNumberList) {
        this.target = new Target(testTargetNumberList);
    }

    public void repeatUntilEnd() {
        OutputView.informStartGame();
        setResultGameInProgress();
        while (checkIsGameStatusInProgress()) {
            playOneTime();
        }
    }

    void playOneTime() {
        this.target.reset();
        Turn turn = new Turn(this.target);
        turn.repeatToEnd();
        OutputView.announceEndOfThisGame();
        checkIsUserRepeatGame();
    }

    boolean checkIsGameStatusInProgress() {
        return this.gameStatus == GameStatus.InProgress;
    }

    void checkIsUserRepeatGame() {
        String oneIfGameRepeatOrTwo = InputView.checkIsGameRepeatFromUserByGetOneOrTwo();
        ExceptionHandler.validateOneIfGameRepeatOrTwo(oneIfGameRepeatOrTwo);
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
