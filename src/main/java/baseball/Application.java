package baseball;

public class Application {

    public static void main(String[] args) {
        Print.gameStart();
        Game game = new Game();
        game.start();
    }
}
