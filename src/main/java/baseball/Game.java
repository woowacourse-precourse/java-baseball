package baseball;

import java.util.List;
import java.util.Objects;

public class Game {
    private Player player;
    private int ball;
    private int strike;

    public void startGame() {
        View.getStartGameMessage();
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
        int gameRound = 0;
        while (gameRound != 1) {
            readyPlayer();
            swingBat(computer.getComputerNumbersList(), player.getPlayerNumbersList());
            gameRound = setResultGame();
            View.getResultGameMessage(gameRound,this.getBall(),this.getStrike());
        }
        checkRestartGame();
    }

    private void readyPlayer() {
        View.getInputMessage();
        player = new Player();
    }

    private void swingBat(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        initBalls();
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerNumbers.get(i), playerNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
    }

    private int setResultGame() {
        if ((ball == 0) && (strike == 0)) {
            return 0;
        } else if (strike == 3) {
            return 1;
        } else {
            return 2;
        }
    }

    private void initBalls() {
        ball = 0;
        strike = 0;
    }

    private void checkRestartGame() {
        View.getRestartGameMessage();
        String inputNumber = getOneInputNumber();
        if (inputNumber.equals("1")) {
            playGame();
        } else {
            View.getEndGameMessage();
        }
    }

    private String getOneInputNumber() {
        String inputNumber = player.inputNumbers();
        Exception.checkInputNumber(inputNumber);
        return inputNumber;
    }

}
