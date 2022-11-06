package baseball;

public class Application {

    private static final int STARTOFGAME = 0;

    public static void main(String[] args) {
        Game game = new Game();
        game.start(STARTOFGAME);
    }
}
