package baseball;

public class Controller {
    private static Game game;

    public void play() {
        int retryChoice = 0;

        while (retryChoice != 2) {
            game = new Game();
            game.startGame();
            retryChoice = game.askRegame();
        }
    }
}
