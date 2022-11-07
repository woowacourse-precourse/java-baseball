package baseball;

public class Application {
    public static final int NUMBER_SIZE = 3;
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(NUMBER_SIZE);
        baseballGame.playGame();
    }
}
