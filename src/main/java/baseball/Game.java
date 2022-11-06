package baseball;

import java.util.List;

public class Game {
    private final Computer computer;
    private final Player player;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String compareResult;
        computer.initComputerNumber();
        do {
            List<Integer> playerNumber = player.enterNumber();
            compareResult = computer.giveResult(playerNumber);
        } while (!isStrikeout(compareResult));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    public boolean isStrikeout(String result) {
        String finishFlag = "3스트라이크";
        return result.equals(finishFlag);
    }
}
