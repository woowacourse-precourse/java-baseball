package baseball;

public class Application {

    static GameController gameController = new GameController();

    public static void main(String[] args) {
        ShowMessage.showGameStart(); // 게임 시작 메세지 출력
        gameController.newGame();
    }

}
