package baseball;

public class Controller {
    Game game = new Game();

    public void run() {
        game.initGame();
        game.playGame();
        game.replayGame();
    }
}
