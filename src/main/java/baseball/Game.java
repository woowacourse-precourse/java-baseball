package baseball;

import java.util.List;
import java.util.Objects;

public class Game {
    private Player player;
    private int ball;
    private int strike;

    public void startGame() {
        System.out.print("숫자 야구 게임을 시작합니다.");
        playGame();
    }
    public void playGame() {
        Computer computer = new Computer();
        int gameRound = 1;
        while (gameRound == 1) {
            System.out.print("숫자를 입력해 주세요 : ");
            player = new Player();
            swingBat(computer.getComputerNumbersList(),player.getPlayerNumbersList());
        }
    }
    private void initBallAndStrike() {
        ball = 0;
        strike = 0;
    }
    public void swingBat(List<Integer> computerNumbers,List<Integer> playerNumbers) {
        initBallAndStrike();
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerNumbers.get(i), playerNumbers.get(i)))
                strike++;
            else if (computerNumbers.contains(playerNumbers.get(i))) ball++;
        }
    }
}
