package baseball;

public class Controller {
    private Game game;

    public Controller() {
        this.game = new Game();
    }

    public void play() {
        int retryChoice = 0;

        while (retryChoice != 2) {
            game.startGame();
            retryChoice = game.askRegame();
        }
    }
}
