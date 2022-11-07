package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.notifyStart();
        do {
            game.start();
            game.notifyRestartOrEnd();
            game.setRestarter(game.getRestartOrEndNumber());
        } while (game.restarter);
    }
}

