package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.view.PlayerView;

import java.util.List;

public class GameController {
    private int strike = 0;
    private int ball = 0;
    PlayerView playerView = new PlayerView();
    UserNumber userNumber = new UserNumber();
    ComputerNumber computerNumber = new ComputerNumber();
    private boolean gaming = true;
    private static final int MAX_GAME_COUNT = 3;

    public void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNumber.setComputerNumber();

        while (gaming) {
            resetStrikeAndBall();
            String playerInput = playerView.playerInput();
            userNumber.setUserNumbers(playerInput);
            calculateScore(userNumber.getUserNumbers(), computerNumber.getComputerNumber());
            printScore();

            if (getStrike() == MAX_GAME_COUNT) {
                restartGame();
            }
        }
    }

    public void calculateScore(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void resetStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    public void printScore() {
        StringBuffer sb = new StringBuffer();
        String printScoreResult;

        if (getStrike() == 0 && getBall() == 0) {
            sb.append("낫싱");
        }
        if (0 < getBall() && getBall() <= MAX_GAME_COUNT) {
            sb.append(getBall()).append("볼 ");
        }
        if (0 < getStrike() && getStrike() <= MAX_GAME_COUNT) {
            sb.append(getStrike()).append("스트라이크 ");
        }

        printScoreResult = sb.toString();
        System.out.println(printScoreResult);

        if (getStrike() == MAX_GAME_COUNT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public void restartGame() {
        boolean gameRestart = playerView.isGameRestart();

        if (gameRestart) {
            computerNumber.setComputerNumber();
        } else {
            gaming = false;
        }
    }
}
