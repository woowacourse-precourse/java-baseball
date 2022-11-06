package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = Game.getGame();
        game.turnOnGame();
        do {
            game.startNewGame();
        } while (game.replayGame());
    }
}
