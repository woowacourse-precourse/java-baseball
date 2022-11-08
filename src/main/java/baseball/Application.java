package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();
        // Illegal Reflective Access Warning 문구 출력 방지
        gameManager.disableWarning();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameManager.getContinuation()) {
            gameManager.startGame();
            gameManager.continueGame();
        }
    }
}
