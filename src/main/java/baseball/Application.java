package baseball;

public class Application {
    public static void main(String[] args) {
        AbstractBaseballGame game = new BaseballGame();
        game.run();
    }
}
