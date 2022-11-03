package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame game = new BaseballGame();

        do {
            try {
                game.play();
            } catch (IllegalArgumentException e) {
                break;
            }
        } while (game.restart());
    }
}
