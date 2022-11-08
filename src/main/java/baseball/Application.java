package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.print(game.opening());

        do {
            game.doGame();
        } while (game.askContinue());
    }
}
