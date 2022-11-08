package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        do {
            baseballGame.start();
        } while (askReGame());
    }

    private static boolean askReGame() {
        ReGame reGame = new ReGame();
        reGame.inputNumber();

        return reGame.isOk();
    }
}
