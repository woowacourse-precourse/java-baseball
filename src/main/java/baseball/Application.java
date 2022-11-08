package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game;
        do {
            game = new Game();
            game.play();
        } while (game.askRetry());
    }
}