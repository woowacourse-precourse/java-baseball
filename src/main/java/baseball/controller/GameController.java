package baseball.controller;

import baseball.model.Computer;
import baseball.utils.Constant;
import baseball.utils.Exception;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class GameController {
    private final InputView inputView;
    private final InputController inputController;
    private final OutputView outputView;
    private final Exception exception;

    private int ball;
    private int strike;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.exception = new Exception();
        this.inputController = new InputController();
    }

    public void startGame() {
        outputView.getStartGameMessage();
        playGame();
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    private void playGame() {
        Computer computer = new Computer();
        int gameRound = Constant.GAME_INIT;
        while (gameRound != Constant.RESULT_FULL_STRIKE) {
            Player player = inputController.readyPlayer();
            swingBat(computer.getComputerNumbers(), player.getPlayerNumbers());
            gameRound = setResultGame();
            outputView.getResultGameMessage(gameRound, this.getBall(), this.getStrike());
        }
        checkRestartGame();
    }

    public void swingBat(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        initBalls();
        IntStream.range(Constant.GAME_INIT, Constant.GAME_SIZE).forEach(i -> {
            checkResult(computerNumbers, playerNumbers, i);
        });
    }

    public void checkResult(List<Integer> computerNumbers, List<Integer> playerNumbers, int index) {
        int i = index;
        if (Objects.equals(computerNumbers.get(i), playerNumbers.get(i))) {
            strike++;
            return;
        }
        if (computerNumbers.contains(playerNumbers.get(i))) {
            ball++;
        }
    }

    private int setResultGame() {
        if ((ball == Constant.GAME_INIT) && (strike == Constant.GAME_INIT)) {
            return Constant.RESULT_NOTHING;
        }
        if (strike == Constant.GAME_SIZE) {
            return Constant.RESULT_FULL_STRIKE;
        }
        return Constant.RESULT_COMBINE;
    }

    private void initBalls() {
        ball = Constant.GAME_INIT;
        strike = Constant.GAME_INIT;
    }

    public void checkRestartGame() {
        outputView.getRestartGameMessage();
        int inputNumber = inputController.getOneInputNumber();
        if (inputNumber == Constant.PLAYER_RESTART) {
            playGame();
        }
        outputView.getEndGameMessage();
    }

}
