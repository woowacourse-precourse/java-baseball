package baseball;

public class Application {
    private static Game game = new BaseballGame();

    public static void main(String[] args) {
        game.run();
    }
}
