package baseball;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();
        Computer computer = new Computer();
        User user = new User();

        game.turnOnGame(computer, user);

        do {
            game.startNewGame();
        } while (game.replayGame());

    }
}
