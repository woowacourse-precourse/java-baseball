package baseball;

public class Application {
    public static void main(String[] args) {
        GameStart gameStart = new GameStart();

        boolean gameLoop = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameLoop) {
            gameLoop = gameStart.gameStart();
        }
    }
}
