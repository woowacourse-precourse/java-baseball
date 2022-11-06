package baseball;

import java.util.List;
import java.util.Objects;

public class Game {
    private Player player;

    public  void startGame() {
        System.out.print("숫자 야구 게임을 시작합니다.");
        playGame();
    }
    public void playGame() {
        Computer computer = new Computer();
        int gameRound = 1;
        while (gameRound == 1) {
            System.out.print("숫자를 입력해 주세요 : ");
            player = new Player();
        }
    }
}
