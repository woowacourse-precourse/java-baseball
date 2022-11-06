package baseball;

public class Game {
    Computer computer;
    Player player;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void startGame(int choice) {
        if (choice == 0) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            gameStart();
        } else if (choice == 1) {
            gameStart();
        }
    }

    private void gameStart() {

    }
}
