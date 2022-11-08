package baseball.controller;

import baseball.model.Target;
import baseball.constant.GameStatus;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Game {
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;
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
        OutputView.informEndOfThisGame();
        checkIsUserRepeatGame();
    }

    boolean checkIsGameStatusInProgress() {
        return this.gameStatus == GameStatus.IN_PROGRESS;
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
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    void setResultGameEnd() {
        this.gameStatus = GameStatus.END;
    }

}
