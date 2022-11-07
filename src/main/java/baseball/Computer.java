package baseball;

import java.util.List;

public class Computer {
    private GamePlayer gamePlayer;

    public Computer() {
        this.gamePlayer = new GamePlayer();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> threeNumbers = askForThreeNumbers();
    }

    List<Integer> askForThreeNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        return gamePlayer.getThreeNumber();
    }
}
