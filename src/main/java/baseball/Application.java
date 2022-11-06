package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = Game.turnOnGame();
        do {
            game.startNewGame();
        } while (game.replayGame());
    }
}
