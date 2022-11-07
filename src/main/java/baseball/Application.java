package baseball;

public class Application {

    public static void main(String[] args) {

        BaseballGame baseballGame = new BaseballGame();

        // TODO: 프로그램 구현
        while (true) {
            baseballGame.startNewGame();
            if (!baseballGame.doesRestart()) {
                break;
            }
        }
    }
}
