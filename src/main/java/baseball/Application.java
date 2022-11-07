package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Game game = new NumberBaseball();
        do {
            game.play();
        } while (game.choiceRestartOrExit() == game.START);
    }
}
