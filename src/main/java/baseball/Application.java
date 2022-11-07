package baseball;

public class Application {

    private static final int PLAYAGAINMODE = 2;

    public static void main(String[] args) {
        Game game = new Game();
        int playAgainReturn;
        do {
            playAgainReturn = game.startAndPlayAgain();
        } while (playAgainReturn == PLAYAGAINMODE);
    }
}
