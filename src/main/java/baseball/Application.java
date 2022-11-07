package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View.start();
        boolean isFinished;
        do {
            Game game = new Game();
            isFinished = game.start();

        } while (isFinished);
    }
}
