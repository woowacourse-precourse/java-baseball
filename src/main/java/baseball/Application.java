package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        Play play = new Play();

        baseballGame.start();

        do {
            play.game();
        } while (!baseballGame.isRestart());
    }
}
