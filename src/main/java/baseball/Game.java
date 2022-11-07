package baseball;

import java.util.List;
import java.util.Objects;

public class Game {
    private Player player;
    private int ball;
    private int strike;

    public void startGame() {
        getStartGameMessage();
        playGame();
    }

    private void playGame() {
        Computer computer = new Computer();
        int gameRound = 0;
        while (gameRound != 1) {
            getInputMessage();
            player = new Player();
            swingBat(computer.getComputerNumbersList(), player.getPlayerNumbersList());
            gameRound = setResultGame();
            getResultGameMessage(gameRound);
        }
        checkRestartGame();
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
        getRestartGameMessage();
        String inputNumber = getOneInputNumber();
        if (inputNumber.equals("1")) {
            playGame();
        } else {
            getEndGameMessage();
        }
    }

    private String getOneInputNumber() {
        String inputNumber = player.inputNumbers();
        Exception.checkInputNumber(inputNumber);
        return inputNumber;
    }

    private void getRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void getEndGameMessage() {
        System.out.println("게임을 완전히 종료합니다.");
    }

    private void getResultGameMessage(int gameRound) {
        if (gameRound == 0) {
            System.out.println("낫싱");
        } else if (gameRound == 1) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private void getStartGameMessage() {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

    private void getInputMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

}
