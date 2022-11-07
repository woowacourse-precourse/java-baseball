package baseball;

public class Application {

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();

        System.out.println(Constants.START_MESSAGE);
        do {
            game.start();
        } while (game.isGameContinue());

    }
}
