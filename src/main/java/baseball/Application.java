package baseball;

public class Application {

    private static final int FIRST_START_OFGAME = 0;

    public static void main(String[] args) {
        Game game = new Game();
        game.start(FIRST_START_OFGAME);
    }
}
