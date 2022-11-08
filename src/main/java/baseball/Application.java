package baseball;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();

        try {
            baseBallGame.logic();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
