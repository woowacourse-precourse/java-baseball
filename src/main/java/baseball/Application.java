package baseball;

public class Application {
    public static void main(String[] args) {
        int restartOrEnd;
        do {
            Game game = new Game();
            restartOrEnd = game.run();
        } while (restartOrEnd == 1);

    }
}
