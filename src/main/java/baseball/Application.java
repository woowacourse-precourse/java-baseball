package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.opening());

        do {
            game.doGame();
        } while (game.askContinue());
    }
}
