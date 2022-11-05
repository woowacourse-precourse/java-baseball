package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.opening());

        do {
            try {
                game.doGame();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        } while (game.askContinue());
    }
}
