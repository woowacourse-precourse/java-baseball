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
    private Player player;
    private int ball;
    private int strike;
    private final InputView inputView;
    private final InputController inputController;
    private final OutputView outputView;
    private final Exception exception;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.exception = new Exception();
        this.inputController = new InputController() ;
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
            inputController.readyPlayer();
            swingBat(computer.getComputerNumbers(), player.getPlayerNumbers());
            gameRound = setResultGame();
            outputView.getResultGameMessage(gameRound, this.getBall(), this.getStrike());
        }
        checkRestartGame();
    }

    private void swingBat(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        initBalls();
        IntStream.range(0,3).forEach(i -> {
            if (Objects.equals(computerNumbers.get(i), playerNumbers.get(i))){
            strike++;
            }
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        });
    }

    // 3 개의 상태를 나타내는 코드를 리펙 ?
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

    private void checkRestartGame() {
        outputView.getRestartGameMessage();
        int inputNumber = getOneInputNumber();
        if (inputNumber == Constant.PLAYER_RESTART) {
            playGame();
        }
        outputView.getEndGameMessage();
    }

    private int getOneInputNumber() {
        try {
            int oneDigitNumber = Integer.parseInt(inputView.inputNumbers());
            exception.checkOneDigitNumber(oneDigitNumber);
            return oneDigitNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong input Number Format");
        }
    }

}
