package baseball;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();

        do {
            game.start();

        } while (game.wantRestart());
    }


}
