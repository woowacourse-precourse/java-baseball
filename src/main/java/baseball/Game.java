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
            gameRound = getResultGame();
        }
        checkRestartGame();
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
    public int getResultGame() {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return 1;
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 0;
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
            return 1;
        }
    }
    public void checkRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNumber = player.inputNumbers();
        Exception.checkInputNumber(inputNumber);
        if (inputNumber.equals("1")) playGame();
        else System.out.println("게임을 완전히 종료합니다.");
    }
}
