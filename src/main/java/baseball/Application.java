package baseball;

public class Application {
    private Player player;

    public Application() {
        player = new Player();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.restartLoop();
    }
}
