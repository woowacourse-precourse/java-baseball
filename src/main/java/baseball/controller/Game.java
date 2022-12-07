package baseball.controller;

import baseball.model.Computer;
import baseball.utils.Constant;
import baseball.utils.Exception;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Objects;

public class Game {
    private Player player;
    private int ball;
    private int strike;

    private final InputView inputView;
    private final OutputView outputView;
    public Game(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
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
            readyPlayer();
            swingBat(computer.getComputerNumbers(), player.getPlayerNumbersList());
            gameRound = setResultGame();
            outputView.getResultGameMessage(gameRound,this.getBall(),this.getStrike());
        }
        checkRestartGame();
    }

    private void readyPlayer() {
        inputView.getInputMessage();
        player = new Player();
    }

    private void swingBat(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        initBalls();
        for (int i = Constant.GAME_INIT; i < Constant.GAME_SIZE; i++) {
            if (Objects.equals(computerNumbers.get(i), playerNumbers.get(i))) {
                strike++;
            }
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
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
        String inputNumber = getOneInputNumber();
        if (inputNumber.equals("1")) {
            playGame();
        }
        outputView.getEndGameMessage();
    }

    private String getOneInputNumber() {
        String inputNumber = inputView.inputNumbers();
        Exception.checkInputNumber(inputNumber);
        return inputNumber;
    }

}
