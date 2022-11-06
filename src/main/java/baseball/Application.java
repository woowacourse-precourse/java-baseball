package baseball;

public class Application {
    private static boolean gameStatus = true;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (gameStatus) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.executeGame();
        }
    }
}
