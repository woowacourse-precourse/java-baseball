package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        game.start();

        while (game.again) {
            game.play();
        }

    }
}
