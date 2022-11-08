package baseball;

public class BaseballGame {
    Computer computer;
    Player player;

    BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void preceed() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (player.continueGame());
        finishEntireGame();
    }

    }

    void finishOneGame() {

    }

    boolean continueGame() {
        return false;
    }

    void finishEntireGame() {

    }


}



