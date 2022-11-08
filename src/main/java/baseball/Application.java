package baseball;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();
        game.printStart();
        do {
            game.startGame();
        }while (game.isFinishGame());
    }
}
