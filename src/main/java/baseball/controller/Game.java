package baseball.controller;

import baseball.model.Computer;
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
    public static final int GAME_INIT = 0;
    public static final int GAME_SIZE = 3;
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
        int gameRound = GAME_INIT;
        while (gameRound != 1) {
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
        for (int i = GAME_INIT; i < GAME_SIZE; i++) {
            if (Objects.equals(computerNumbers.get(i), playerNumbers.get(i))) {
                strike++;
            }
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
    }

    private int setResultGame() {
        if ((ball == GAME_INIT) && (strike == GAME_INIT)) {
            return 0;
        }
        if (strike == GAME_SIZE) {
            return 1;
        }
        return 2;
    }

    private void initBalls() {
        ball = GAME_INIT;
        strike = GAME_INIT;
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
