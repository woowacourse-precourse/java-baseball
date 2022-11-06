package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            gameManager.startGame();
            gameManager.continueGame();
        }
    }
}
