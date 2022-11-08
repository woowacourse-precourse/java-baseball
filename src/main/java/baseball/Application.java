package baseball;

public class Application {
    public static void main(String[] args) {

        Game game = Game.getGame();
        Computer computer = Computer.getComputer();
        User user = User.getUser();

        game.turnOnGame(computer, user);

        do {
            game.startNewGame();
        } while (game.replayGame());

    }
}
